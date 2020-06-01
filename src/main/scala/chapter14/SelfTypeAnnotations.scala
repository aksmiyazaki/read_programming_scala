package chapter14

abstract class SubjectObserver {
  type S <: Subject
  type O <: Observer

  trait Subject {
    self: S =>

    private var observers = List[O]()

    def addObserver(observer: O) = observers ::= observer

    // The row like this doesn`t compile.
    //def notifyObservers() = observers.foreach(_.receiveUpdate(this))
    def notifyObservers() = observers.foreach(_.receiveUpdate(self))
  }

  trait Observer {
    def receiveUpdate(subject: S)
  }

}

case class Button(label: String) {
  def click(): Unit = {}
}

object ButtonSubjectObserver extends SubjectObserver {
  type S = ObservableButton
  type O = ButtonObserver

  class ObservableButton(label: String) extends Button(label) with Subject {
    override def click() = {
      super.click()
      notifyObservers()
    }
  }

  trait ButtonObserver extends Observer {
    def receiveUpdate(button: ObservableButton)
  }
}


import ButtonSubjectObserver._

class ButtonClickObserver extends ButtonObserver {
  val clicks = new scala.collection.mutable.HashMap[String, Int]()

  def receiveUpdate(button: ObservableButton) = {
    val count = clicks.getOrElse(button.label, 0) + 1
    clicks.update(button.label, count)
  }
}


/// Aliasing this with Self type annotation
class C1 { self =>
  def talk(message: String) = println("C1.talk: " + message)
  class C2 {
    class C3 {
      def talk(message: String) = self.talk("C3.talk: " + message)
    }
    val c3=new C3
  }
  val c2=new C2
}



object SelfTypeAnnotations extends App {
  val buttons = Vector(new ObservableButton("one"), new ObservableButton("two"))
  val observer = new ButtonClickObserver
  buttons foreach (_.addObserver(observer))
  for (i <- 0 to 2) buttons(0).click()
  for (i <- 0 to 4) buttons(1).click()
  println(observer.clicks)


  // Aliasing this with self
  val c1=new C1
  c1.talk("Hello")
  c1.c2.c3.talk("World")
}
