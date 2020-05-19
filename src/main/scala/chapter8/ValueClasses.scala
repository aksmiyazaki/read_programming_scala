package chapter8


class Meter (val value: Double) extends AnyVal {
  def +(m: Meter): Meter = new Meter(value + m.value)
}

object ValueClasses extends App {
  val x = new Meter(3.1)
  val y = new Meter(2.9)
  val z = x + y
  println(z.value)
}
