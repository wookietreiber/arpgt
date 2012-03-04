import sbt._
import Keys._

import Dependencies._
import BuildSettings._

object BuildSettings {
  val buildOrganization = "com.github.arpgt"
  val buildVersion      = "0.1"
  val buildScalaVersion = "2.9.1"

  val buildSettings = Defaults.defaultSettings ++ Seq (
    organization := buildOrganization,
    version      := buildVersion,
    scalaVersion := buildScalaVersion
  )
}

object ArpgtBuild extends Build {
  lazy val root = Project ( "arpgt", file ("."),
    settings = buildSettings ++ Seq (
      libraryDependencies ++= Seq ( specs2 ),
      initialCommands in Compile in console := """
        import rpg._
      """
    )
  )
}

object Dependencies {
  val specs2 = "org.specs2" %% "specs2" % "1.8.2" % "test"
}
