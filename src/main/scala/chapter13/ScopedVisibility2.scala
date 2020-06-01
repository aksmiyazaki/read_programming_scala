//package chapter13
//
//package scopeA {
//  class PrivateClass1(private[this] val privateField1: Int) {
//    private[this] val privateField2 = 1
//
//    def equalFields(other: PrivateClass1) =
//        (privateField1 == other.privateField1) && // ERROR
//        (privateField2 == other.privateField2) && // ERROR
//        (nested == other.nested) // ERROR
//
//    class Nested {
//      private[this] val nestedField = 1
//    }
//
//    private[this] val nested = new Nested
//
//  }
//
//  class PrivateClass2 extends PrivateClass1(1) {
//    val field1 = privateField1 // ERROR
//    val field2 = privateField2 // ERROR
//    val nField = new Nested().nestedField // ERROR
//  }
//
//  class PrivateClass3 {
//    val privateClass1 = new PrivateClass1(1)
//    val privateField1 = privateClass1.privateField1 // ERROR
//    val privateField2 = privateClass1.privateField2 // ERROR
//    val privateNField = privateClass1.nested.nestedField // ERROR
//  }
//}
//
//object ScopedVisibility2 {
//
//}
