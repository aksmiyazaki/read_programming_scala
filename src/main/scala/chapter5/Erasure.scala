package chapter5

object M {
  /// This type of declaration is not allowed because it is the same after Type erasure (JVM forgets type arguments
  /// for parametrized types.
  // def m(seq: Seq[Int]): Unit = println(s"Seq[Int]: $seq")
  // def m(seq: Seq[String]): Unit = println(s"Seq[String]: $seq")
  /// ========================================================== ///

  // One way to do it is work around with implicits
  implicit object IntMarker
  implicit object StringMarker

  def m(seq: Seq[Int])(implicit im: IntMarker.type): Unit = {
    println(s"Seq[Int]: $seq")
  }

  def m(seq: Seq[String])(implicit sm: StringMarker.type): Unit = {
    println(s"Seq[String]: $seq")
  }
}

object Erasure extends App {
  import M._
  m(Seq(1,2,3,4))
  m(Seq("Potato", "Tomato", "Onion"))
}
