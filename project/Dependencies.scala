import sbt.{ExclusionRule, _}


object Dependencies {
  val embeddedDependencies = Seq(
    "javadb" % "javadb" % "10.10.2.0"
  )

  val rootDependencies = (
    embeddedDependencies
    ).map(_ excludeAll ExclusionRule(organization = "javax.mail"))
}
