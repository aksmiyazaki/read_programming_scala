package chapter3.PatternMatchingStuff

object MatchingSequences extends App {
  val aSeq = Seq(1, 2, 3, 4, 5)

  def seqToString[T](seq: Seq[T]): String = seq match {
    case head +: tail => s"$head +: "+ seqToString(tail)
    case Nil => "Nil"
  }

  println(seqToString(aSeq))
}
