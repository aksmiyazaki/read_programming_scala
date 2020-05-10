package chapter7

object ForComprehensionDetails extends App {
  val states = List("RS", "SC", "SP", "RJ", "PR")

  /// For comprehensions are a syntactic sugar for using map, flatMap, withFilter  and foreach
  /// When used without a yield, it is similar to foreach.
  println("This operation yields the same res")
  for {
    s <- states
  } println(s)

  println("As this operation")
  states foreach println

  /// A for comprehension with a yield of results correspond to a map
  println("For compehension below")
  val r = for {
    s <- states
  } yield s.toLowerCase()

  println(r)

  println(states.map((x) => x.toLowerCase()))

  /// A for comprehension with more than one generator, all but the last are converted to flatMap.
  val r2 = for {
    s <- states
    c <- s
  } yield s"$c-${c.toLower}"
  println(r2)

  println(states flatMap (_.toSeq map (x => s"$x-${x.toLower}")))

  // Adding a guard...
  val r3 = for {
    s <- states
    c <- s
    if Seq('R', 'P', 'S').contains(c)
  } yield s"$c-${c.toLower}"

  println(r3)
  val r4 = states flatMap (_.toSeq withFilter (Seq('R', 'P', 'S').contains(_)) map (c => s"$c-${c.toLower}"))
  println(r4)


  // Defining a variable inside the for
  val r5 = for {
    s <- states
    c <- s
    if Seq('R', 'P', 'S').contains(c)
      c2 = s"$c-${c.toLower}"
  } yield c2

  val r6 = states flatMap (_.toSeq withFilter (Seq('R', 'P', 'S').contains(_)) map (c => {
    val c2 = s"$c-${c.toLower}"
    c2
  }))
  println(r5)
  println(r6)
}
