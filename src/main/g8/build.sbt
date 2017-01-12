lazy val root = project.in(file("."))
  .settings(
    name := "$name;format="lower,word"$",
    version := "$version$",
    organization := "$organization$",
    scalaVersion := "2.11.12",
    initialCommands := "import $organization$.$name;format="lower,word"$._"
  )
  .settings(BuildSettings.assemblySettings)
  .settings(BuildSettings.compilerSettings)
  .enablePlugins(BuildInfoPlugin)
  .settings(
    buildInfoKeys := Seq[BuildInfoKey](organization, name, version),
    buildInfoPackage := "$organization$.$name;format="lower,word"$.generated"
  )
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