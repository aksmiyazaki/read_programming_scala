package chapter7

object EitherUnderstanding extends App {
  // Since Either is a Logical Extension to Option, first let's see how the previous example looks like
  def positive(i: Int): Either[String,Int] =
    if (i > 0) Right(i) else Left(s"Negative number $i")

  val res1 =
    for {
      i1 <- positive(3).right
      i2 <- positive(i1 * 3).right
      i3 <- positive(i2 * 6).right
      i4 <- positive(i2 * 12).right
    } yield (i1 + i2 + i3 + i4)

  println(res1)

  val res2 =
    for {
      i1 <- positive(3).right
      i2 <- positive(i1 * -1).right
      i3 <- positive(i2 * -6).right
      i4 <- positive(i3 * 9).right
    } yield (i1 + i2 + i3 + i4)

  // It stops on the first return of Left.
  println(res2)

  val l: Either[String, Int] = Left("This is an error.")
  val r: Either[String, Int] = Right(42)

  println(l.left.map(_.size))
  println(r.left.map(_.size)) // This returns the RIGHT value without any modification


  println(l.right.map(_.toDouble)) // This returns the LEFT value without any modification
  println(r.right.map(_.toDouble))

  /// An example of how Either is used

  def convAndAdd(s1: String, s2: String): Either[NumberFormatException, Int] = {
    try{
      Right(s1.toInt + s2.toInt)
    } catch {
      case nfe: NumberFormatException => Left(nfe)
    }
  }

  println(convAndAdd("x", "1"))
  println(convAndAdd("2", "2"))
}
