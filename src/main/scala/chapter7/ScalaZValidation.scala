package chapter7

import scalaz._, std.AllInstances._, scalaz.Validation.FlatMap._

object ScalaZValidation extends App {
  // The same example for Option, Either and TRY:
  def positive(i: Int): Validation[List[String], Int] = {
    if (i > 0) Success(i)
    else Failure(List(s"Negative integer $i"))
  }

  val res1 =
    for {
      i1 <- positive(3)
      i2 <- positive(i1 * 3)
      i3 <- positive(i2 * 6)
      i4 <- positive(i2 * 12)
    } yield (i1 + i2 + i3 + i4)
  // There`s no difference in res1 and res2 since we are using a for comprehension (short-circuited).
  println(res1)

  val res2 =
    for {
      i1 <- positive(3)
      i2 <- positive(i1 * -1)
      i3 <- positive(i2 * -6)
      i4 <- positive(i3 * 9)
    } yield (i1 + i2 + i3 + i4)

  println(res2)

  println(positive(10) +++ positive(15))

  // Note that both errors are evaluated.
  println(positive(5) +++ positive(-10) +++ positive(10) +++ positive(-20))
}
