package chapter6

object Clojure extends App {

  var factor = 2
  val multiplier = (i: Int) => i * factor

  println((1 to 10) filter (_ % 2 == 0) map multiplier reduce (_ * _))

  factor = 3

  println((1 to 10) filter (_ % 2 == 0) map multiplier reduce (_ * _))

}
