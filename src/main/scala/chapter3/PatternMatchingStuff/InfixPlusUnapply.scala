package chapter3.PatternMatchingStuff

case class With[A, B](a: A, b: B)

object InfixPlusUnapply extends App{

  val seq = Seq(With("Potato", 22), With("Tomato", 23), With(22.3f, 12))

  for (v <- seq){
    v match {
      case "Potato" With 22 => println("It is a Potato!") // Infix notation (chapter3.PatternMatchingStuff.With) + unapply of chapter3.PatternMatchingStuff.With obj.
      case With(_:Float, _) => println("We have a float as first param")
      case _ =>  println("This clause is tomaticous")
    }
  }

}
