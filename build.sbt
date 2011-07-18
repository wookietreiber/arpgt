
name := "arpgt"

version := "0.0.1"

organization := "org.software-is-free-on-kashyyyk"

scalaVersion := "2.9.0-1"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases"

libraryDependencies ++= Seq(
	"se.scalablesolutions.akka" %  "akka-actor" % "1.1.3",
	"org.specs2"                %% "specs2"     % "1.4"   % "test"
)

initialCommands := """
	import rpg._
"""
