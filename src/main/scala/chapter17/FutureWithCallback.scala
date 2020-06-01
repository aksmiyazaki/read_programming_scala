package chapter17
import scala.concurrent.Future
import scala.util.{Try, Success, Failure}

object FutureWithCallback extends App {
  import scala.concurrent.ExecutionContext.Implicits.global
  case class ThatsOdd(i: Int) extends RuntimeException(s"odd $i received!")

  val doComplete: PartialFunction[Try[String],Unit] = {
    case Success(s) => println(s)
    case Failure(f) => println(f)
  }

  val futures = (0 to 9) map {
    case i if i % 2 == 0 => Future.successful(i.toString)
    case i => Future.failed(ThatsOdd(i))
  }

  println("Building")
  futures map (_ onComplete doComplete)
}
