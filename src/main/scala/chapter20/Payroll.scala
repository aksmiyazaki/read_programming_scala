package chapter20
import scala.language.postfixOps
import DSL._
import Common._


object Payroll extends App {

  val biweeklyDeductions = biweekly { deduct =>
    deduct federal_tax (25.0 percent)
    deduct state_tax (5.0 percent)
    deduct insurance_premiums (500.0 dollars)
    deduct retirement_savings (10.0 percent)
  }

  println(biweeklyDeductions)
  val annualGross = 100000.0
  val gross = biweeklyDeductions.gross(annualGross)
  val net = biweeklyDeductions.net(annualGross)
  print(f"Biweekly pay (annual: $$${annualGross}%.2f): ")
  println(f"Gross: $$${gross}%.2f, Net: $$${net}%.2f")

}
