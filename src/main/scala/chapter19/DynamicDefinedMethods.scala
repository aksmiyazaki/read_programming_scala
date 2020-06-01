package chapter19

import scala.language.dynamics

case class CLINQ[T](records: Seq[Map[String, T]]) extends Dynamic {
  def selectDynamic(name: String): CLINQ[T] =
    if (name == "all" || records.length == 0) this
    else {
      val fields = name.split("_and_")
      val seed = Seq.empty[Map[String, T]]
      val newRecords = (records foldLeft seed) {
        (results, record) =>
          val projection = record filter {
            case (key, value) => fields contains key
          }
          // Drop records with no projection.
          if (projection.size > 0) results :+ projection
          else results
      }
      CLINQ(newRecords)
    }

  def applyDynamic(name: String)(field: String): Where =
    name match {
      case "where" => new Where(field)
      case _ => throw CLINQ.BadOperation(field, """Expected "where".""")
    }

  protected class Where(field: String) extends Dynamic {
    def filter(value: T)(op: (T, T) => Boolean): CLINQ[T] = {
      val newRecords = records filter {
        _ exists {
          case (k, v) => field == k && op(value, v)
        }
      }
      CLINQ(newRecords)
    }

    def applyDynamic(op: String)(value: T): CLINQ[T] = op match {
      case "EQ" => filter(value)(_ == _)
      case "NE" => filter(value)(_ != _)
      case _ => throw CLINQ.BadOperation(field, """Expected "EQ" or "NE".""")
    }
  }

  override def toString: String = records mkString "\n"
}

object CLINQ {

  case class BadOperation(name: String, msg: String) extends RuntimeException(
    s"Unrecognized operation $name. $msg")

}


object DynamicDefinedMethods extends App {
  def makeMap(name: String, capital: String, statehood: Int) =
    Map("name"->name,"capital"->capital,"statehood"->statehood)

  val states = CLINQ(List(
    makeMap("Alaska", "Juneau", 1959),
    makeMap("California", "Sacramento", 1850),
    makeMap("Illinois", "Springfield", 1818),
    makeMap("Virginia", "Richmond", 1788),
    makeMap("Washington", "Olympia", 1889)))

  println(states.name)

}
