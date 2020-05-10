package chapter6

object CurryingAndFunctionTransformations extends App {

  def concatenate(s1: String, s2: String): String = s1 + " " +s2

  // Turns concatenate into a curried function
  def curriedConcatenate: String => String => String = (concatenate _).curried

  val t1 = concatenate("Potato", "Tomato")
  val t2 = curriedConcatenate("Potato")("Tomato")

  println(t1)
  println(t2)

  // Curried or methods with multiple args lists are useful to specialize functions based on its params
  val concatenateWithPotato = curriedConcatenate("Potato!")(_)
  println(concatenateWithPotato("test"))

  val tuple = ("String one", "String two")

  // You can pass just a tuple for a function, just need to create a tupled version of it
  def concatenateTuple = Function.tupled(concatenate _)
  println(concatenateTuple(tuple))

  // Also you can lyft a partial function to return an option
  def partialCase : PartialFunction[String, String] = {
    case "Test" => "Defined"
  }

  println(partialCase("Test"))
  //println(partialCase("Undefined will throw exception"))

  def liftedPartial = partialCase.lift

  /// The lifted version returns an Option, which throws no errors when not defined.
  println(liftedPartial("Test"))
  println(liftedPartial("Undefined"))
}
