import sbt._
import Keys._

object ArpgtBuild extends Build {
  lazy val root = Project ( "arpgt", file ("."),
    settings = Defaults.defaultSettings ++ Seq (
      organization         := "com.github.arpgt",
      version              := "0.1.0-SNAPSHOT",
      scalaVersion         := "2.9.1-1",
      crossScalaVersions   := Seq ( "2.9.1", "2.9.1-1", "2.9.2-RC2" ),
      libraryDependencies ++= Seq (
        "org.specs2" %% "specs2" % "1.9" % "test"
      ),
      initialCommands in Compile in console  += """
        import rpg._
      """
    )
  )
}
