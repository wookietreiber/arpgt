
name := "arpgt"

organization := "com.github.arpgt"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.0-M7"

libraryDependencies ++= Seq (
  "org.specs2" % "specs2_2.10.0-M7" % "1.12.1.1" % "test"
)

initialCommands in (Compile, consoleQuick) <<= initialCommands in Compile

initialCommands in Compile in console += """
  import rpg._
"""

