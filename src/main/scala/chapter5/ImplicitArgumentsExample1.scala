package chapter5

object ImplicitArgumentsExample1 extends App {
  implicit val currentTaxRate = 0.08F

  def calcTax(amount: Float)(implicit rate: Float): Float = amount * rate
  println(calcTax(50000F))
}
