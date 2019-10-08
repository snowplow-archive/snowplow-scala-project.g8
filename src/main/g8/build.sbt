/*
 * Copyright (c) $year$ Snowplow Analytics Ltd. All rights reserved.
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

lazy val root = project.in(file("."))
  .settings(
    organization := "$organization$",
    name := "$name;format="lower,word"$",
    version := "$version$",
    scalaVersion := "$scalaVersion$",
    initialCommands := "import $organization$.$name;format="lower,word"$._"
  )
  .settings(BuildSettings.assemblySettings)
  .settings(BuildSettings.compilerSettings)
  .settings(
    resolvers ++= Seq(
      "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
    ),
    libraryDependencies ++= Seq(
      Dependencies.decline,
      Dependencies.fs2,

      Dependencies.specs2,
      Dependencies.scalaCheck
    )
  )
  .settings(BuildSettings.helpersSettings)