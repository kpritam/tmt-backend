import sbt._

object Libs {
  val ScalaVersion = "2.13.2"

  val `scalatest` = "org.scalatest" %% "scalatest" % "3.1.1" //Apache License 2.0
}

object CSW {
  val Version: String = "321cc9b"

  val `csw-framework` = "com.github.tmtsoftware.csw" %% "csw-framework" % Version
  val `csw-services`  = "com.github.tmtsoftware.csw" %% "csw-services"  % Version
}
