sbtPlugin := true

name := "sbt-checkstyle-plugin"

organization := "io.shiftleft" /* TODO: change back to com.etsy once PR to etsy is merged */

version := "3.1.1"

scalaVersion := "2.10.4"

libraryDependencies ++= Seq(
  "com.puppycrawl.tools" % "checkstyle" % "6.15",
  "net.sf.saxon" % "Saxon-HE" % "9.6.0-5",
  "org.scalatest" % "scalatest_2.10" % "2.2.1" % "test",
  "junit" % "junit" % "4.11" % "test",
  "com.github.stefanbirkner" % "system-rules" % "1.6.0" % "test"
)

xerial.sbt.Sonatype.sonatypeSettings

publishTo := {
  val jfrog = "https://shiftleft.jfrog.io/shiftleft/"
  if (isSnapshot.value)
    Some("snapshots" at jfrog + "libs-snapshot-local")
  else
    Some("releases"  at jfrog + "libs-release-local")
}

publishMavenStyle := true

pomExtra := <url>https://github.com/ShiftLeftSecurity/sbt-checkstyle-plugin</url>
  <licenses>
    <license>
      <name>MIT License</name>
      <url>http://opensource.org/licenses/MIT</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:ShiftLeftSecurity/sbt-checkstyle-plugin.git</url>
    <connection>scm:git:git@github.com:ShiftLeftSecurity/sbt-checkstyle-plugin.git</connection>
  </scm>
  <developers>
    <developer>
      <id>ajsquared</id>
      <name>Andrew Johnson</name>
      <url>github.com/ajsquared</url>
    </developer>
  </developers>

scalastyleConfig := file("scalastyle.xml")

scalastyleFailOnError := true
