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

  EvalByNameOper(genString)
}
