package chapter8
package chapter8

trait Observer[-State] {
  def receiveUpdate(state: State): Unit
}

trait Subject[State] {
  private var observers : List[Observer[State]] = Nil

  def addObserver(observer: Observer[State]): Unit = observers ::= observer

  def notifyObservers(state: State): Unit = observers foreach (_.receiveUpdate(state))
}

abstract class Widget

trait Clickable {
  def click(): Unit = updateUI()

  protected def updateUI(): Unit
}

trait ObservableClicks extends Clickable with Subject[Clickable] {
  abstract override def click(): Unit = {
    super.click()
    notifyObservers(this)
  }
}

trait VetoableClicks extends Clickable {
  val maxAllowed = 1
  private var count = 0

  override def click(): Unit = {
    if (count < maxAllowed) {
      count += 1
      super.click()
    }
  }
}

class Button(val label: String) extends Widget with Clickable {
  protected def updateUI(): Unit = println("Ui updated")
}

object StackableTraitsWithVeto extends App {
  // Note the order of trait mixin.
  // If we change the order, the call stack will be different and veto will be called after the update in state.
  val button = new Button("Click Me") with ObservableClicks with VetoableClicks {
    override val maxAllowed: Int = 2
  }

  class ClickCountObserver extends Observer[Clickable] {
    var count = 0

    override def receiveUpdate(state: Clickable): Unit = count += 1
  }

  val bco1 = new ClickCountObserver
  val bco2 = new ClickCountObserver

  button addObserver bco1
  button addObserver bco2

  (1 to 5) foreach (_ => button.click())
  assert(bco1.count == 2, s"bco1.count ${bco1.count}")
  assert(bco2.count == 2, s"bco1.count ${bco2.count}")
  println("Success")
}
