package chapter4.PatternMatchingStuff

object Op extends Enumeration {
  type Op = Value

  val EQ = Value("=")
  val NE = Value("!=")
  val LTGT = Value("<>")
  val LT = Value("<")
}

import chapter4.PatternMatchingStuff.Op._
case class WhereOp[T](columnName: String, op: Op, value: T)
case class WhereIn[T](columnName: String, val1: T, vals: T*)

object MatchingVarArgList extends App {
  val wheres = Seq(
    WhereIn("state", "RS", "SC", "PR"),
    WhereOp("state", EQ, "SP"),
    WhereOp("state", NE, "RS")
  )

  for (expr <- wheres) {
    expr match {
      case WhereIn(st, val1, vals @ _*) => println(s"Check wherein in val1: $val1 varargs: $vals")
      case WhereOp(_, oper, st) => println(s"Check if $st is $oper")
    }
  }
}
