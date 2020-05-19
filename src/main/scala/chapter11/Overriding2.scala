package chapter11


abstract class Widget {
  def draw(): Unit
  override def toString() = "(widget)"
}

trait Clickable {
  def click(): Unit = updateUI()

  protected def updateUI(): Unit
}

class Button(val label: String) extends Widget with Clickable {
  def draw(): Unit = println(s"Drawing: $this")

  protected def updateUI(): Unit = println(s"$this clicked; updating UI")

  override def toString() = s"(button: label=$label, ${super.toString()})"
}

object Overriding2 extends App {

}
