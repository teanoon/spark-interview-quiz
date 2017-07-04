name := "spark-interview-quiz"

version := "1.0"

scalaVersion := "2.11.11"

// provided dependencies
libraryDependencies ++= Seq("org.apache.spark" %% "spark-core" % "2.1.1" % "provided")

// test dependencies
libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.9.1" % "test")
