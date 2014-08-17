package arpgt
package build

import sbt._

object dependencies {
  def Specs2(scalaVersion: String) = CrossVersion.partialVersion(scalaVersion) match {
    case Some((2,11)) => List("org.specs2" %% "specs2-scalacheck" % "2.4.1")
    case Some((2,10)) => List("org.specs2" %% "specs2-scalacheck" % "2.4")
    case _            => Nil
  }
}
