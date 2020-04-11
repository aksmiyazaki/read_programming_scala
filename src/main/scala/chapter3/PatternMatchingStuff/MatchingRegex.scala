package chapter3.PatternMatchingStuff

object MatchingRegex extends App {
  // When creating a regex to match something, use triple quotes.
  val CarExtractorRE = """Vehicle: Car, Model: (.+), Year: ([0-9]{4})""".r
  val BusExtractorRE = """Vehicle: Bus, Model: (.+), SeatNo: ([0-9]+)""".r

  val catalog = Seq(
    "Vehicle: Car, Model: Porshe, Year: 1990",
    "Vehicle: Bus, Model: Mercedes, SeatNo: 25",
    "Whataheckisdis?"
  )

  for(itm <- catalog) {
    itm match {
      case CarExtractorRE(model, year) => println(s"It is a car model $model made in $year")
      case BusExtractorRE(model, seatNo) => println(s"It is a bus model $model with amazing $seatNo seats")
      case _ => println(s"wat? $itm")
    }
  }
}
