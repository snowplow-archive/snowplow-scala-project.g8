$copyright$

// sbt
import sbt._
import Keys._

// Docker
import com.typesafe.sbt.packager.docker.DockerPlugin.autoImport.dockerBaseImage
import com.typesafe.sbt.packager.docker._

// sbt-assembly
/* Uncomment if using sbt-assembly. */
//import sbtassembly._
//import sbtassembly.AssemblyKeys._

object BuildSettings {
  lazy val projectSettings = Seq(
    organization := "$organization$",
    name := "$name;format="lower,word"$",
    version := "$version$",
    scalaVersion := "$scalaVersion$",
    description := "$projectDescription$"
  )

  // Make package (build) metadata available within source code.
  lazy val scalifiedSettings = Seq(
    sourceGenerators in Compile += Def.task {
      val file = (sourceManaged in Compile).value / "settings.scala"
      IO.write(file, """package $organization$.$name;format="lower,word"$.generated
                       |object ProjectSettings {
                       |  val organization = "%s"
                       |  val name = "%s"
                       |  val version = "%s"
                       |  val scalaVersion = "%s"
                       |  val description = "%s"
                       |}
                       |""".stripMargin.format(organization.value, name.value, version.value, scalaVersion.value, description.value))
      Seq(file)
    }.taskValue
  )

  lazy val compilerSettings = Seq[Setting[_]](
    scalacOptions := Seq(
      "-deprecation",
      "-encoding", "UTF-8",
      "-explaintypes",
      "-feature",
      "-language:existentials",
      "-language:experimental.macros",
      "-language:higherKinds",
      "-language:implicitConversions",
      "-unchecked",
      "-Xcheckinit",
      "-Xfuture",
      "-Yno-adapted-args",
      "-Ypartial-unification",
      "-Ywarn-dead-code",
      "-Ywarn-extra-implicit",
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

  lazy val helperSettings = Seq[Setting[_]](
    initialCommands := "import $organization$.$name;format="lower,word"$._"
  )

  lazy val resolverSettings = Seq[Setting[_]](
    resolvers ++= Seq(
      "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
    )
  )

  lazy val dockerSettings = Seq(
    dockerUsername := Some("snowplow"),
    dockerBaseImage := "snowplow-docker-registry.bintray.io/snowplow/base-debian:0.1.0",
    maintainer in Docker := "Snowplow Analytics Ltd. <support@snowplowanalytics.com>",
    daemonUser in Docker := "snowplow",
    dockerExposedPorts ++= Seq(9000, 9001),
    dockerExposedUdpPorts += 4444
  )

  /* Uncomment if using sbt-assembly. */
  /*lazy val assemblySettings = Seq(
    assemblyJarName in assembly := { s"\${moduleName.value}-\${version.value}.jar" },
    assemblyMergeStrategy in assembly := {
      case PathList("META-INF", xs @ _*) => MergeStrategy.discard
      case x => MergeStrategy.first
    }
  )*/
}
