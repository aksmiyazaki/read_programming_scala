package chapter15



object SingletonTypes extends App {
  val s11 = new OtherService1
  val s12 = new OtherService1

  val l1: Logger = s11.logger
  val l2: Logger = s12.logger

  val l11: s11.logger.type = s11.logger
//  val l12: s11.logger.type = s12.logger
}
