import sbt._

object Resolvers {

  val defaultResoulvers = Seq(
    DefaultMavenRepository,
    "Java MVN" at "https://mvnrepository.com/artifact"
  )

}