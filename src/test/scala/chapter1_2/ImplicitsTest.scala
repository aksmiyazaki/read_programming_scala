import chapter1_2.TestImplicitObject.ImplicitObject
import chapter1_2.TestImplicitObject.ImplicitObject._


object ImplicitsTest extends App {
  def implicitPrint(implicit MyImplicitValue: Int): Unit = {
    println(MyImplicitValue)
  }

  println(ImplicitObject.MyImplicitValue)
  implicitPrint
  implicitPrint(25)
}
