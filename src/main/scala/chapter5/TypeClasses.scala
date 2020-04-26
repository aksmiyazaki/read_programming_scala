package chapter5




/// Type classes, aka Extension methods in C#/F#
object TypeClasses extends App {
  implicit class AddressToJSON(v: String) {
    def toPretty():String = {
      s"I Rock! $v"
    }
  }

  val str = "Dude!"
  println(str.toPretty)
}
