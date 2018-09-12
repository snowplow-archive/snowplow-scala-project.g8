lazy val root = project.in(file("."))
  .settings(
    name := "$name;format="lower,word"$",
    version := "$version$",
    organization := "$organization$",
    scalaVersion := "2.11.11",
    initialCommands := "import $organization$.$name;format="lower,word"$._"
  )
  .settings(BuildSettings.assemblySettings)
  .settings(BuildSettings.buildSettings)
  .settings(BuildSettings.scalifySettings)
  .settings(
    resolvers ++= Seq(
      "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
    ),
    libraryDependencies ++= Seq(
      Dependencies.scopt,
      Dependencies.scalaz7,
      Dependencies.json4sJackson,

      Dependencies.specs2,
      Dependencies.scalazSpecs2,
      Dependencies.scalaCheck
    )
  )
  .settings(BuildSettings.helpersSettings)
