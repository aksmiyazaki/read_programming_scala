package chapter5

import scala.annotation.implicitNotFound

sealed trait StateNoLegs

sealed trait StateNoTail

sealed trait StateNoHead

sealed trait StateFinished

case class Tortuguita(legs: Boolean, tail: Boolean, head: Boolean, body: Boolean)

case class Eat[Step](t: Tortuguita)

object DoEat {
  def legs(t: Tortuguita): Eat[StateNoLegs] = Eat(Tortuguita(true, false, false, false))

  def tail(t: Eat[StateNoLegs]): Eat[StateNoTail] = Eat(Tortuguita(true, true, false, false))

  def head(t: Eat[StateNoTail]): Eat[StateNoHead] = Eat(Tortuguita(true, true, true, false))

  def body(t: Eat[StateNoHead]): Eat[StateFinished] = Eat(Tortuguita(true, true, true, true))
}

object Pipeline {
  implicit class toPiped[V](value: V){
    def |>[R](f : V => R) = f(value)
  }
}

object PhantomTypes extends App { /// aka the right order to eat a Tortuguita.
  val t = Tortuguita(false, false, false, false)
  val eat1 = DoEat legs t
  val eat2 = DoEat tail eat1
  val eat3 = DoEat head eat2
  val eat4 = DoEat body eat3
  println(s"Syntax ok: $eat4")

  // Why is this useful?
  // This constrains method call chain:
  // val eatWrong = DoEat tail t
  // val eatWrongAgain = DoEat head t
  //val eatWrongAgainAgain = DoEat body t

  // Fancy way to chain methods with a defined operator
  import Pipeline._
  import DoEat._
  val eaten = legs(t) |>
              tail    |>
              head    |>
              body

  println(s"Syntax Fancy: $eaten")
}
