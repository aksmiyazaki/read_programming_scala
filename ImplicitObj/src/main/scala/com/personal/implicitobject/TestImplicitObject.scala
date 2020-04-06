package com.personal.implicitobject

object TestImplicitObject {
  implicit val MyImplicitValue: Int = 32
  implicit object ImplicitObject {
    implicit val MyImplicitValue: Int = 43
  }
}

