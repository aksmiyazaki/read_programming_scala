package chapter5

object SimpleStateSalesTax {
  implicit val rate: Float = 0.05F
}

case class ComplicatedSalesTaxData(baseRate: Float, isTaxHoliday: Boolean, storeId: Int)

object ComplicatedSalesTax {
  private def extraRateForStore(id: Int): Float = {
    // From store id gets the extra taxes
    0.0F
  }

  implicit def rate(implicit cstd: ComplicatedSalesTaxData): Float = {
    if (cstd.isTaxHoliday) 0.0F
    else cstd.baseRate + extraRateForStore(cstd.storeId)
  }
}

object ImplicitsTaxTest extends App {
  def calcTax(amount: Float)(implicit rate:Float): Float = amount * rate

  {
    import SimpleStateSalesTax.rate
    val amount = 100F
    println(s"Tax on $amount is ${calcTax(amount)}")
  }

  {
    import ComplicatedSalesTax.rate

    implicit val myStore = ComplicatedSalesTaxData(0.06F, false, 13)

    val amount = 100F
    println(s"Complicated tax on $amount is ${calcTax(amount)}")
  }
}
