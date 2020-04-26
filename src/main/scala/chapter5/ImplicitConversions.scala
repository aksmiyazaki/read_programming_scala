package chapter5

import scala.language.implicitConversions

object ImplicitConversions extends App {
  case class Potato(s: String)
  object Potato {
    implicit def FromString(s: String): Potato = Potato(s)

    implicit def FromPotato(s: Potato): String = s.s
  }

  class StuffToDo{
    def m(s:Potato): Unit = println(s"I'm ${s.s}")
  }

  val o1: StuffToDo = new StuffToDo
  // Using String type here, the compiler looks for an implicit conversion
  // in other places trying to convert from string to m's required type.
  o1.m("Batato")

}
