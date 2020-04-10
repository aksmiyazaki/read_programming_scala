object MatchingTuples extends App {
  val aSeq = Seq(("Scala", "Funny", "Language"),("Golang", "Eficient", "Language"), ("Python", "Easy", "Language"))

  for (tuple <- aSeq){
    val str =
      tuple match {
        case ("Scala", val1, val2) => s"Hey! Scala $val1 $val2"
        case (name, "Easy", _) => s"Want an Easy Language? Try $name"
        case (val1, val2, val3) => s"The rest is $val1 $val2 $val3"
      }
    println(str)
  }
}
