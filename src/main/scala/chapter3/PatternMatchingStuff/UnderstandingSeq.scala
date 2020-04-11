package chapter3.PatternMatchingStuff

object UnderstandingSeq extends App {
  // The matching at Seq clause is also a case using a tuple.
  // There is a object called `+:` which is used in this case (the method unapply of this object is used.

  val aSeq = Seq(1, 2, 3, 4, 5)

  def procSeq[T](aSeq: Seq[T]): Unit = {
    aSeq match {
      case +:(head, tail) => print(s"$head +: ")
        procSeq(tail)
      case Nil => print("Nil")
    }
  }

  procSeq(aSeq)

  println()
  println("===============================================")

  // Because of the infix operator, the syntax can be more idiomatic.
  def idiomaticProcSeq[T](aSeq: Seq[T]): Unit = {
    aSeq match {
      case head +: tail => print(s"$head +: ")
        procSeq(tail)
      case Nil => print("Nil")
    }
  }

  idiomaticProcSeq(aSeq)

}
