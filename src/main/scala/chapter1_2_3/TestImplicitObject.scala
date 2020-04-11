package chapter1_2_3

object TestImplicitObject {
  implicit val MyImplicitValue: Int = 32
  implicit object ImplicitObject {
    implicit val MyImplicitValue: Int = 43
  }
}

