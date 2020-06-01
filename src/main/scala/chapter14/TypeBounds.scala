package chapter14


class Person(val name: String)
class CompletePerson(name: String, val surname: String, val age: Int) extends Person(name)
class SpecializedPerson(name: String, surname: String, age: Int, role: String)
  extends CompletePerson(name, surname, age)

object TypeBounds extends App {
  def ParametrizedMethodUpperBounded[T <: CompletePerson](p: T): Unit = {
    println(s"This param is accepted ${p}")
  }

  def ParametrizedMethodLowerBounded[T >: CompletePerson](p: T): Unit = {
    println(s"This param is accepted ${p}")
  }

  val p = new Person("John")
  val cp = new CompletePerson("John", "Doe", 22)
  val sp = new SpecializedPerson("John", "Doe", 22, "Carpenter")

  println("UPPER BOUNDED")
  ParametrizedMethodUpperBounded(cp)
  ParametrizedMethodUpperBounded(sp)
  //ParametrizedMethodUpperBounded(p) // This triggers a runtime error

  // ======= BOOK EXAMPLE =========
  class Parent(val value: Int) { //
    override def toString = s"${this.getClass.getName}($value)"
  }
  class Child(value: Int) extends Parent(value)

  val op1: Option[Parent] = Option(new Child(1)) // Some(Child(1))
  val p1: Parent = op1.getOrElse(new Parent(10)) // Result: Child(1)

  val op2: Option[Parent] = Option[Parent](null) // None
  val p2a: Parent = op2.getOrElse(new Parent(10)) // Result: Parent(10)
  val p2b: Parent = op2.getOrElse(new Child(100)) // Result: Child(100)

  val op3: Option[Parent] = Option[Child](null) // None
  val p3a: Parent = op3.getOrElse(new Parent(20)) // Result: Parent(20)
  // Result: Child(200) // => This only works because the method getOrElse is declared lower bounded.
  val p3b: Parent = op3.getOrElse(new Child(200))

  // To illustrate, lets declare an opt type.
//  case class Opt[+A](value: A = null) {
//    def getOrElse(default: A): A = if (value != null) value else default
//  }
  // The lower bound is tied with Covariance // Contravariance to enable the method return as a
  // Collection of both Parent and Child.

  val seqEx = 1 +: Seq(2 ,3)
  val seqEx2 = 0.1 +: seqEx


  // ==============================




  println()
  println("LOWER BOUNDED")

  ParametrizedMethodLowerBounded(cp)
  ParametrizedMethodLowerBounded(p)
  ParametrizedMethodLowerBounded(sp) // Shouldn't this trigger an error?!?!?!?!?!??!?!?!?!

}
