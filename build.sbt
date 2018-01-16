
name := "misc-jmh"

organization := "io.github.brharrington"

scalaVersion := "2.12.4"

enablePlugins(JmhPlugin)

libraryDependencies ++= Seq(
    "com.netflix.servo" % "servo-core" % "0.12.17"
)
