logLevel := Level.Warn

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.10")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.4.1")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.0.6")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "1.6.0")
//addSbtPlugin("com.localytics" % "sbt-dynamodb" % "2.0.3") // Uncomment to use for DynamoDB testing