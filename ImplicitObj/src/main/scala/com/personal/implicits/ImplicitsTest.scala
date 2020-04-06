package com.personal.implicits
import com.personal.implicitobject.TestImplicitObject._

object ImplicitsTest extends App {
  def implicitPrint(implicit MyImplicitValue: Int): Unit = {
    println(MyImplicitValue)
  }

  println(ImplicitObject.MyImplicitValue)
  implicitPrint
  implicitPrint(25)
}
