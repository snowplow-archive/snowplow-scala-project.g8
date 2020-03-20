$copyright$

lazy val root = project
  .in(file("."))
  .settings(BuildSettings.projectSettings)
  .settings(BuildSettings.scalifiedSettings)
  .settings(BuildSettings.compilerSettings)
  .settings(BuildSettings.helperSettings)
  .settings(BuildSettings.resolverSettings)
  .settings(BuildSettings.dockerSettings)
  //.settings(BuildSettings.assemblySettings)
  .settings(
    libraryDependencies ++= Seq(
      Dependencies.catsCore,
      Dependencies.catsEffect,
      Dependencies.decline,
      Dependencies.specs2
    )
  )
