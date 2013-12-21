name := "arpgt"

organization := "com.github.wookietreiber"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.10.3"

libraryDependencies ++= Seq (
  "org.specs2" %% "specs2-core" % "2.3.6" % "test"
)

initialCommands in (Compile, consoleQuick) <<= initialCommands in Compile

initialCommands in Compile in console += """
  import rpg._
"""
