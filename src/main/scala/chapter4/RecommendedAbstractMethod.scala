package chapter4

abstract class Fruit {
  // It is recommended to declare val's as no-argument methods
  def IsTomato: Boolean
}


//Because the following classes in the inheritance can implement it both as methods...
class Apple extends Fruit {
  def IsTomato: Boolean = {
    println("Hey, I'm Apple")
    false
  }
}

// and Vals
class Tomato extends Fruit {
  val IsTomato = true
}

/// This is an application of something called Referential Transparency

object RecommendedAbstractMethod {
}
