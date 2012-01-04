import sbt._
import Keys._

import Resolvers._
import Dependencies._
import BuildSettings._

object BuildSettings {
  val buildOrganization = "com.github.wookietreiber"
  val buildVersion      = "0.1"
  val buildScalaVersion = "2.9.1"
  val akkaVersion       = "1.2"

  val buildSettings = Defaults.defaultSettings ++ Seq (
    organization := buildOrganization,
    version      := buildVersion,
    scalaVersion := buildScalaVersion
  )
}

object ArpgtBuild extends Build {

  // -----------------------------------------------------------------------
  // project definition
  // -----------------------------------------------------------------------

  lazy val root = Project ( "arpgt", file ("."),
    settings = buildSettings ++ Seq (
      libraryDependencies ++= Seq ( actor, specs2 )
    )
  )

}

object Dependencies {

  // -----------------------------------------------------------------------
  // compile
  // -----------------------------------------------------------------------

  val actor = "se.scalablesolutions.akka" % "akka-actor" % akkaVersion

  // -----------------------------------------------------------------------
  // test
  // -----------------------------------------------------------------------

  val specs2 = "org.specs2" %% "specs2" % "1.7.1" % "test"

}

object Resolvers {
  val typesafe = "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases"
}
