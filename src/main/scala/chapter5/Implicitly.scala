package chapter5



object Implicitly extends App {
  case class MyList[A](list: List[A]) {
    def sortBy1[B](f: A => B)(implicit ord: Ordering[B]): List[A] = list.sortBy(f)(ord)
    // This is a shorthand syntax for the above method
    // Because B: Ordering doesn`t have a reference name like above, `implicitly` resolves its value.
    def sortBy2[B: Ordering](f: A => B) : List[A] = list.sortBy(f)(implicitly(Ordering[B]))
  }

  val list = MyList(List(1,3,5,4,6,2))
  println(list sortBy1 (i => -i))
  println(list sortBy2 (i => -i))

}
