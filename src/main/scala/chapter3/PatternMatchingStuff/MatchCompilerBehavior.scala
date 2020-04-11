package chapter3.PatternMatchingStuff

object MatchCompilerBehavior extends App {

  def surpriseCheckY(y: Int): Unit = {
    for {
      x <- Seq(100, 99, 98)
    } {
      val str = x match {
        // in this line, because y is lowercase, matches anything because the compiler
        // assumes that a lowercase variable is the name of a new variable that will hold the extracted value.
        case y => "found y: " + y
        case i: Int => "Int: " + i
      }
      println(str)
    }
  }

  surpriseCheckY(99)

  // To have the correct behavior (prints found y only when x == 99 we have to do the following:
  println("===========//===========//============")
  def correctCheckY(y: Int): Unit = {
    for {
      x <- Seq(100, 99, 98)
    } {
      val str = x match {
        // check that y is enclosed with backticks
        case `y` => "found y: " + y
        case i: Int => "Int: " + i
      }
      println(str)
    }
  }

  correctCheckY(99)

  // Moreover, a term that starts with an Uppercase letter is assumed to be a type name.
}
