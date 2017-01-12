$copyright$

lazy val root = project
  .in(file("."))
  .settings(BuildSettings.projectSettings)
  .settings(BuildSettings.scalifiedSettings)
  .settings(BuildSettings.compilerSettings)
  .settings(BuildSettings.helperSettings)
  .settings(BuildSettings.resolverSettings)
