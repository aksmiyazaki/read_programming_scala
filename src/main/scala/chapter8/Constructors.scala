package chapter8


class Person(val name: String, val surName: String, val age: Int) {

  def this(name: String) = this(name, "", 0)
  def this(name : String, surName: String) = this(name,surName, 0)
  // This will trigger an error because it is referencing an secondary contructor that comes before in the code
  // Personally I don't like this kind of construction which requires ordering in code.
  def this() = this("NoName")
}


object Constructors extends App {
  val p = new Person()
}
