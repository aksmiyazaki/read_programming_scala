package chapter11


abstract class Alpha {
  def doAlphaStuff
}

class Beta extends Alpha {
  def doAlphaStuff: Unit = println("Doing stuff") // use override keyword only when overriding concrete members
}

object Overriding extends App {
  val b = new Beta
  b.doAlphaStuff
}
