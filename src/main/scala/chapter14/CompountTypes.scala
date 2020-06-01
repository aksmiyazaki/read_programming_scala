package chapter14

class SampleClass {
  def myMethod = println("Hey")
}

trait Logging {
  def log(message:String): Unit = println(s"Log: $message")
}

object CompountTypes extends App {
  val compound = new SampleClass with Logging
  compound.myMethod
  compound.log("Called Mymethod")
}
