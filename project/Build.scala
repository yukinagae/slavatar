import sbt._
import sbt.Keys._

object MyBuild extends Build {

  lazy val project = Project(
    id = "slavatar",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "slavatar",
      organization := "com.yukinagae",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.2",
      // add other settings here
      libraryDependencies ++= Seq( //
        "org.specs2" %% "specs2" % "2.3.8" % "test", //
        "junit" % "junit" % "4.11" % "test" //
        ) //
        ))
}
