
name := "arpgt"

organization := "com.github.wookietreiber.arpgt"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.0-RC2"

libraryDependencies ++= Seq (
  "org.specs2" % "specs2" % "1.12.2" % "test" cross CrossVersion.full
)

initialCommands in (Compile, consoleQuick) <<= initialCommands in Compile

initialCommands in Compile in console += """
  import rpg._
"""

