package chapter1_2_3


object LazyVal extends App {
  lazy val iHaveAnExpensiveInitialization = Initialize()

  def Initialize():String = {
    println("Initializing...")
    Thread.sleep(1000 * 10)
    println("Initialization completed")
    "Initialized!"
  }

  println("Started")
  println(iHaveAnExpensiveInitialization)
  println(iHaveAnExpensiveInitialization)
  println(iHaveAnExpensiveInitialization)
  println("Ended")
}
