package chapter1_2_3

object CallByName extends App {
  val rootString = "teste"
  var callNo = 0

  def genString(): String = {
    callNo += 1
    rootString + callNo
  }

  def EvalByNameOper(name: => String): Unit = {
    println(name) // name is evaluated each time it is called
    println(name) // name is evaluated each time it is called
    println(name) // name is evaluated each time it is called
    println(name) // name is evaluated each time it is called
  }

  def NotEvaluatedByName(name: String): Unit = {
    println(name)
    println(name)
    println(name)
    println(name)
  }

  callNo = 0
  EvalByNameOper(genString)
  callNo = 0
  NotEvaluatedByName(genString)
}
