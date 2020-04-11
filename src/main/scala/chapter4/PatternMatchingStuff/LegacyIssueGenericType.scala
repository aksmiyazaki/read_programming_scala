package chapter4.PatternMatchingStuff

object LegacyIssueGenericType extends App {
  // Watch this BEAUTY!
  // This returns the first case match in both cases
  // The reason is a legacy compatibility issue of Java which doesn`t carry the types to byte code when using
  // Generics... To match the type of a seq, match the head type...
  for {
    itm <- Seq(Seq(1,2,3,4), Seq("batata", "polenta", "térmica"))
  } {
    itm match {
      case seq: Seq[Int] => println(s"Hey $seq is a Seq of Ints!")
      case seq: Seq[String] => println(s"Hey $seq is a Seq of Strings!")
    }
  }
}
