package chapter15

class Service{
  class Logger {
    def log(msg: String): Unit = println(s"log: $msg")
  }

  val logger: Logger = new Logger
}

object PathDependantError {
  val s1 = new Service
  // Line below triggers type error.
  // The type os s2.Logger is different than s1.Logger.
  //val s2 = new Service { override val logger = s1.logger }
}
