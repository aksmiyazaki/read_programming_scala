case class Address(street: String, city: String, country: String)
case class Person(name: String, age: Int, address: Address)

object DeepMatching extends App {
  // Examine contents of instances of case classes!
  val alice = Person("Alice", 32, Address("Bento Gonçalves 244", "Porto Alegre", "Brazil"))
  val jota = Person("Jota", 65, Address("Ipiranga 7200", "Porto Alegre", "Brazil"))
  val pepe = Person("Pépe", 22, Address("Ipiranga 5213", "Porto Alegre", "Brazil"))

  for(person <- Seq(alice, jota, pepe)){
    val str = person match {
      case Person(name, age, Address(street, _, _)) if age > 60 => s"Hey $name, you are on covid-19 risk group, stay at $street"
      case Person("Pépe", _, _) => "PÉÉÉÉÉÉÉÉÉÉPE"
      case Person("Alice", _, Address(wonderland, _, _ )) => s"Hey Alice, is this $wonderland wonderland?"
    }

    println(str)
  }


  val itemSeq = Seq(("Car", 20000), ("Boat", 100000), ("Plane", 3000000))
  val withIdx = itemSeq.zipWithIndex

  for(itm <- withIdx) {
    val str = itm match {
      case ((item, value), idx) => f"$idx: $item - $$$value%.2f"
    }
    println(str)
  }
}
