package chapter11

trait AbstractTrait {
  val divisor: Int
  val calc = 1.0 / divisor
  println(s"Values are $divisor and $calc")
}

trait LazyAbstractTrait {
  val divisor: Int
  lazy val calc = 1.0 / divisor
  //println(s"Values are $divisor and $calc") // this can't be here, otherwise the calc will be used and evaluated.
}

object InitializationTraitIssues extends App {
  val aObj = new AbstractTrait {
    val divisor = 10
  }
  println(s"Values are ${aObj.divisor} and ${aObj.calc}")

  val anotherObj = new LazyAbstractTrait {
    val divisor = 10
  }
  println(s"Values are ${anotherObj.divisor} and ${anotherObj.calc}")


  val aObjUsingPreInitializedFields = new {
    val divisor = 10
  } with AbstractTrait

  println(s"Values are ${aObjUsingPreInitializedFields.divisor} and ${aObjUsingPreInitializedFields.calc}")

}
