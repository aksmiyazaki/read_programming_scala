package chapter3.PatternMatchingStuff

object OtherUsefulUses extends App {

  case class Address(street: String, city: String, country: String)

  case class Person(name: String, age: Int, address: Address)

  case class PersonSimple(name: String, age: Int)

  // Make a value extraction directly in a declaration
  val Person(name, age, _) = Person("Bob", 22, Address("Test", "1", "2"))
  println(s"Extracted $name and $age using pattern matching!")

  val aSeq = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9)
  // Also useful in lists...
  val listHead +: listTail = aSeq
  println(s"List first el $listHead and its rest $listTail")

  val listTail2 :+ listHead2 = aSeq
  println(s"List last el $listHead2 and its rest $listTail2")

  /// The Pattern matching inside if statements can be used, but I think that it is not
  /// Very useful in deep matching because the placeholder '_' can't be used, the reason is again
  /// Something related with JVM.

  // Another useful use of pattern matching is make function literals of complex arguments easier to use...
  val addrSeq = Seq(
    Address("Bento", "Porto Alegre", "Brazil"),
    Address("Ipirange", "Porto Alegre", "Brazil")
  )

  val sperSeq = Seq(
    PersonSimple("Bob", 99),
    PersonSimple("Caiq", 22)
  )

  val zipped = sperSeq.zip(addrSeq)
  println(zipped)

  // To extract values, we can use a pattern matching inside a map.
  zipped map {
    case(PersonSimple(name, age), Address(state, city, country))
      => println(s"This is $name, with $age yo living at $state, $city, $country")
    case _ => "Invalid match"
  }

  // Decompose a string
  val firstWord = """(\w+)\s.*""".r
  val firstWord(fs) = "Hey I'm doing this"
  println(fs)

}
