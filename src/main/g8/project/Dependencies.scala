$copyright$

import sbt._

object Dependencies {

  object V {
    // Java

    // Scala third-party
    val decline    = "0.6.2"
    val catsCore   = "1.6.1"
    val catsEffect = "1.4.1"
    val circe      = "0.11.1"
    val fs2        = "1.0.5"

    // Scala first-party

    // Testing
    val specs2     = "4.7.0"
    val scalaCheck = "1.14.1"
  }

  // Java

  // Scala third-party
  val decline    = "com.monovore" %% "decline" % V.decline
  val catsCore   = "org.typelevel" %% "cats-core" % V.catsCore
  val catsEffect = "org.typelevel" %% "cats-effect" % V.catsEffect
  val circe      = List("circe-core", "circe-generic", "circe-parser", "circe-literal").map("io.circe" %% _ % V.circe)
  val fs2        = "co.fs2" %% "fs2-core" % V.fs2

  // Scala first-party

  // Testing
  val specs2     = "org.specs2"     %% "specs2-core" % V.specs2     % Test
  val scalaCheck = "org.scalacheck" %% "scalacheck"  % V.scalaCheck % Test

}
