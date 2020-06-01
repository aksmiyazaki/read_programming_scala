package chapter13

class Person private (val name: String, val age: Int) // This class cannot be instantiated by New.

object Person {
  def apply(name: String, age: Int): Unit ={
    new Person(name, age)
  }
}

object VisibilityOnConstructors extends App {
  val p1 = Person("bob", 22)
  //val p2 = new Person("obi", 11)
}
