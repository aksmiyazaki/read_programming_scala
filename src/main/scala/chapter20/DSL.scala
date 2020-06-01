package chapter20
import Common._

object DSL {
  def biweekly(f: DeductionsBuilder => Deductions) =
    f(new DeductionsBuilder("Biweekly", 26.0))

  class DeductionsBuilder(
                           name: String,
                           divisor: Double = 1.0,
                           deducts: Vector[Deduction] = Vector.empty) extends Deductions(
    name, divisor, deducts) {
    def federal_tax(amount: Amount): DeductionsBuilder = {
      deductions = deductions :+ Deduction("federal taxes", amount)
      this
    }

    def state_tax(amount: Amount): DeductionsBuilder = {
      deductions = deductions :+ Deduction("state taxes", amount)
      this
    }

    def insurance_premiums(amount: Amount): DeductionsBuilder = {
      deductions = deductions :+ Deduction("insurance premiums", amount)
      this
    }

    def retirement_savings(amount: Amount): DeductionsBuilder = {
      deductions = deductions :+ Deduction("retirement savings", amount)
      this
    }
  }

}