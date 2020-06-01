package chapter14
import scala.language.implicitConversions

object Serialization {
  case class Writable(value: Any) {
    def serialized: String = s"-- $value --"
  }

  implicit def fromInt(i: Int) = Writable(i)
  implicit def fromFloat(f: Float) = Writable(f)
  implicit def fromString(s: String) = Writable(s)
}


object ContextSerialization {
  case class Rem[A](value: A) {
    def serialized: String = s"-- $value --"
  }

  type Writable[A] = A => Rem[A]
  implicit val fromInt: Writable[Int] = (i:Int) => Rem(i)
  implicit val fromFloat: Writable[Float] = (f:Float) => Rem(f)
  implicit val fromString: Writable[String] = (s:String) => Rem(s)
}

object ViewBounds extends App {
  import Serialization._
  object RemoteConnection {
    def write[T <% Writable](t: T): Unit =
      println(t.serialized) // Use stdout as the "remote connection"
  }

  RemoteConnection.write(100) // Prints -- 100 --
  RemoteConnection.write(3.14f) // Prints -- 3.14 --
  RemoteConnection.write("hello!") // Prints -- hello! --

  /// AVOID! It is being discussed to deprecate!!!!
  /// Below is the same functionality using context bounds.
  import ContextSerialization._
  object RemoteConnection2 {
    def write[T : ContextSerialization.Writable](t: T): Unit =
      println(t.serialized) // Use stdout as the "remote connection"
  }

  RemoteConnection2.write(100)
  RemoteConnection2.write(3.5f)
  RemoteConnection2.write("Hellou")
}




