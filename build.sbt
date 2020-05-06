inThisBuild(
  Seq(
    scalaVersion := "2.13.2",
    version := "0.1.0-SNAPSHOT",
    organization := "com.github.tmtsoftware.tmt-backend",
    organizationName := "ThoughtWorks",
    scalafmtOnCompile := true,
    resolvers ++= Seq(
      "jitpack" at "https://jitpack.io",
      Resolver.bintrayRepo("lonelyplanet", "maven")
    ),
    scalacOptions ++= Seq(
      "-encoding",
      "UTF-8",
      "-feature",
      "-unchecked",
      "-deprecation",
      "-Xlint:_,-missing-interpolator",
      "-Ywarn-dead-code"
    )
  )
)

lazy val `tmt-backend` = (project in file("tmt-backend"))
  .settings(
    libraryDependencies ++= Seq(
      CSW.`csw-services`,
      CSW.`csw-framework`
    )
  )
