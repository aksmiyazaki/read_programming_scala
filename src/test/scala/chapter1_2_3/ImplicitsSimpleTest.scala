import chapter1_2_3.TestImplicitObject._


object ImplicitsSimpleTest extends App {
  def implicitPrint(implicit MyImplicitValue: Int): Unit = {
    println(MyImplicitValue)
  }

  println(ImplicitObject.MyImplicitValue)
  implicitPrint
  implicitPrint(25)
}
