$copyright$

import sbt._

object Dependencies {

  object V {
    // Java

    // Scala third-party
    val catsCore   = "2.1.1"
    val catsEffect = "2.1.3"
    val circe      = "0.13.0"

    // Scala first-party

    // Testing
    val specs2     = "4.10.1"
    val scalaCheck = "1.14.3"
  }

  // Java

  // Scala third-party
  val catsCore   = "org.typelevel" %% "cats-core" % V.catsCore
  val catsEffect = "org.typelevel" %% "cats-effect" % V.catsEffect
  val circe      = List("circe-core", "circe-generic", "circe-parser", "circe-literal").map("io.circe" %% _ % V.circe)

  // Scala first-party

  // Testing
  val specs2     = "org.specs2"     %% "specs2-core" % V.specs2     % Test
  val scalaCheck = "org.scalacheck" %% "scalacheck"  % V.scalaCheck % Test

}
