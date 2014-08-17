import arpgt.build.dependencies._

name := "arpgt"

organization := "com.github.wookietreiber"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.11.2"

libraryDependencies ++= Specs2(scalaVersion.value)

initialCommands in (Compile, consoleQuick) <<= initialCommands in Compile

initialCommands in Compile in console += """
  import rpg._
"""

crossScalaVersions := Seq("2.11.2", "2.10.4")

autoAPIMappings := true
