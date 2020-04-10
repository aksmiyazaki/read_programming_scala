object MediumPatternMatching extends App {
  for (x <- Seq(1, 2, 2.7, "one", "two", "four")) {
    val str = x match {
      case 1 => "int 1"
      case i: Int => "another integer: " + i
      case d: Double => "a Double: " + d
      case "one" => "A one in string"
      case s: String => "another string " + s
      case unexpected => "unexpected value " + unexpected
    }

    println(str)
  }

  /// Same case above, but using placeholder `_`
  for (x <- Seq(1, 2, 2.7, "one", "two", "four")) {
    val str = x match {
      case 1 => "int 1"
      case _: Int => "another integer: " + x
      case _: Double => "a Double: " + x
      case "one" => "A one in string"
      case _: String => "another string " + x
      case _ => "unexpected value " + x
    }

    println(str)
  }

  // Compiler expects:
  // Starts with Uppercase Letter: Type
  // Starts with Lowercase Letter: variable name
}
