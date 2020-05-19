package chapter8

object NiceTraitMixingAvoidingInheritance extends App {
  case class Location(country: String, uf: String)

  trait PersonState {
    val name: String
    val age: Int
  }

  case class Person(name: String, age: Int) extends PersonState

  trait EmployeeState{
    val role: String
    val sallary: Double
  }

  case class Employee(name: String, age: Int, role: String, sallary: Double) extends PersonState with EmployeeState

  val p1 = Employee("Roberto Carlos", 122, "Singer/Songwriter", 1222220202020.0)
  println(p1)

  val p2 = Person("Ayrton Lairton", 22)
  println(p2)
}
