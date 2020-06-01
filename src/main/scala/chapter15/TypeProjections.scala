package chapter15

trait Logger {
  def log(message: String): Unit
}

class ConsoleLogger extends Logger {
  def log(message: String): Unit = println(s"log: $message")
}

trait OtherService {
  type Log <: Logger
  val logger: Log
}

class OtherService1 extends OtherService {
  type Log = ConsoleLogger
  val logger: ConsoleLogger = new ConsoleLogger
}



object TypeProjections extends App {
//  val l1:Service.Log = new ConsoleLogger // This references Service Obj (doesnt exists)
//  val l2:Service1.Log = new ConsoleLogger // This references Service1 Obj (doesnt exists)
//
//  val l3:Service#Log = new ConsoleLogger // Doesnt type check
  val l4: OtherService1#Log = new ConsoleLogger
}
