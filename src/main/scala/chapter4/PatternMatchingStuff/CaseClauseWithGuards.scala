package chapter4.PatternMatchingStuff

object CaseClauseWithGuards extends App {
  val aSeq = Seq(1,2,3,4,5)

  for(v <- aSeq) {
    val str = v match {
      case _ if v % 2 == 0 => s"$v is Even"
      case _ => s"$v is Odd"
    }

    println(str)
  }
}
