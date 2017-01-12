/*
 * Copyright (c) 2017 Snowplow Analytics Ltd. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */

// SBT
import sbt._
import Keys._

/**
 * Common settings-patterns for Snowplow apps and libaries.
 * To enable any of these you need to explicitly add Settings value to build.sbt
 */
object BuildSettings {

  // Makes package (build) metadata available withing source code
  lazy val scalifySettings = Seq(sourceGenerators in Compile <+= (sourceManaged in Compile, version, name, organization, scalaVersion) map { (d, v, n, o, sv) =>
    val file = d / "settings.scala"
    IO.write(file, """package $organization$.$name;format="lower,word"$.generated
                     |object ProjectMetadata {
                     |  val version = "%s"
                     |  val name = "%s"
                     |  val organization = "%s"
                     |  val scalaVersion = "%s"
                     |}
                     |""".stripMargin.format(v, n, o, sv))
    Seq(file)
  })

  lazy val buildSettings = Seq[Setting[_]](
    organization := "$organization$",
    scalaVersion := "2.11.8",
    crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.1"),
    scalacOptions := Seq(
      "-deprecation",
      "-encoding", "UTF-8",
      "-feature",
      "-unchecked",
      "-Ywarn-dead-code",
      "-Ywarn-inaccessible",
      "-Ywarn-infer-any",
      "-Ywarn-nullary-override",
      "-Ywarn-nullary-unit",
      "-Ywarn-numeric-widen",
      "-Ywarn-unused",
      "-Ywarn-value-discard"
    ),
    javacOptions := Seq(
      "-source", "1.8",
      "-target", "1.8",
      "-Xlint"
    )
  )

  lazy val helpersSettings = Seq[Setting[_]](
    initialCommands := "import $organization$.$name;format="lower,word"$._"
  )
}
