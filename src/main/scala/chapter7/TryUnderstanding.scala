package chapter7

import scala.util.Try

object TryUnderstanding extends App {
  // The same example for Option and Either:
  def positive(i: Int): Try[Int] = Try {
    assert(i > 0, s"Negative number $i")
    i
  }

  val res1 =
    for {
      i1 <- positive(3)
      i2 <- positive(i1 * 3)
      i3 <- positive(i2 * 6)
      i4 <- positive(i2 * 12)
    } yield (i1 + i2 + i3 + i4)

  println(res1)

  val res2 =
    for {
      i1 <- positive(3)
      i2 <- positive(i1 * -1)
      i3 <- positive(i2 * -6)
      i4 <- positive(i3 * 9)
    } yield (i1 + i2 + i3 + i4)

  println(res2)


}
