package chapter7

object ForComprehensionsOption extends App {
  val res = Vector(Some(10), None, Some(20))

  val res2 = for {
    Some(i) <- res
  } yield 2 * i

  println(res2) // So far so good, basic for comprehension

  /// Above for comprehension translation
  // Step 1
  val res3 = for {
    Some(i) <- res withFilter {
      case Some(i) => true
      case None => false
    }
  } yield 2 * i

  println(res3)

  // Step 2, removing the outer for comprehension
  val res4 = res withFilter{
    case Some(i) => true
    case None => false
  } map {
    case Some(i) => i * 2
  }
  println(res4)


  /// for comprehension on dependant tasks
  def positive(i: Int): Option[Int] = if(i > 0) Some(i) else None

  val res21 =
    for {
      i1 <- positive(3)
      i2 <- positive(i1 * 3)
      i3 <- positive(i2 * 6)
      i4 <- positive(i2 * 12)
    } yield (i1 + i2 + i3 + i4)

  println(res21)

  val res22 =
    for {
      i1 <- positive(3)
      i2 <- positive(i1 * -1)  // Once a None is returned, the subsequent operations turn into no-ops.
      i3 <- positive(i2 * -6)
      i4 <- positive(i3 * 9)
    } yield (i1 + i2 + i3 + i4)

  println(res22) // Thats why this returns None /\
}
