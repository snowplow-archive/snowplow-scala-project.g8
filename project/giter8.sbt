addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.0.6")
addSbtPlugin("org.foundweekends.giter8" % "sbt-giter8" % "0.11.0")
libraryDependencies += { "org.scala-sbt" %% "scripted-plugin" % sbtVersion.value }