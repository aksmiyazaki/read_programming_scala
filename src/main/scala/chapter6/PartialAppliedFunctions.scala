package chapter6

object PartialAppliedFunctions extends App {

  /// Note multiple args list.
  def concatenate(s1: String)(s2: String):String = s1+" "+s2

  val partialAppliedConcatenate = concatenate("FIXED") _

  println(partialAppliedConcatenate("Potato"))

}
