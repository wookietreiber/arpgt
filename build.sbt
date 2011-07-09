
name := "rpg-tools"

version := "0.1-SNAPSHOT"

scalaVersion := "2.9.0-1"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases"

libraryDependencies ++= Seq(
	"se.scalablesolutions.akka" %  "akka-actor" % "1.1.3",
	"org.specs2"                %% "specs2"     % "1.4"   % "test"
)

initialCommands := """import rpg._"""

