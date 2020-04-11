package chapter3.PatternMatchingStuff

object SimplePatternMatching extends App {
  // A simple matching
  val bools = Seq(true, false)

  for (bool <- bools) {
    bool match {
      case true => println("Got heads")
      case false => println("Got Tails")
    }
  }
}
