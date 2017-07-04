name := "spark-interview-quiz"

version := "1.0"

scalaVersion := "2.12.1"

// compile dependencies
libraryDependencies ++= Seq("org.apache.spark" %% "spark-core_2.11" % "2.1.1")

// test dependencies
libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.9.1" % "test")
