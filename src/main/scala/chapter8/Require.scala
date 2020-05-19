package chapter8

object Require extends App {
  def sumPositiveIntegers(x: Int, y: Int): Int = {
    require(areBothPositiveIntegers(x, y))
    x + y
  }

  def areBothPositiveIntegers(x: Int, y: Int) = {
    x > 0 && y > 0
  }

  println(sumPositiveIntegers(1, 2))
  try {
    println(sumPositiveIntegers(-1, -2))
  } catch {
    case e => println(s"Error while validating: ${e.getMessage}")
  }
}
