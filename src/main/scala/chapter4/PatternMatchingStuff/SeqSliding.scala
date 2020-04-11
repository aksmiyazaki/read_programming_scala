package chapter4.PatternMatchingStuff

object SeqSliding extends App {
  val aSeq = Seq(1,2,3,4,5,6,7,8,9,10)

  val slide = aSeq.sliding(3).toList

  println(slide)
}
