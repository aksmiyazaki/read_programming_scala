package chapter14

trait Subject {

  import scala.language.reflectiveCalls

  type State
  // Observer is a Structural Type. It defines that the type must have a receiveUpdate method
  // Note that state here is Any, because we can`t declare it as a State.
  // Also, the name coupling is an issue (but for a more complex object, it may make sense)
  type Observer = {def receiveUpdate(state: Any): Unit}
  private var observers: List[Observer] = Nil

  def addObserver(observer: Observer): Unit = observers ::= observer

  def notifyObservers(state: State): Unit = observers foreach (_.receiveUpdate(state))
}


object StructuralTypes extends App {
  import scala.language.reflectiveCalls

  object observer {
    def receiveUpdate(state: Any): Unit = println("got one! "+state)
  }

  val subject = new Subject {
    type State = Int
    protected var count = 0
    def increment(): Unit =
    {
      count += 1
      notifyObservers(count)
    }
  }

  subject.increment()
  subject.increment()
  subject.addObserver(observer)
  subject.increment()
  subject.increment()
}
