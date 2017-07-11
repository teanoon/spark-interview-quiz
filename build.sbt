name := "spark-interview-quiz"

version := "1.0"

scalaVersion := "2.11.11"

// compile dependencies
libraryDependencies += "com.typesafe.scala-logging" %% "scala-logging" % "3.7.1"

// provided dependencies
libraryDependencies ++= Seq("org.apache.spark" %% "spark-core" % "2.1.1" % "compileOnly")
libraryDependencies ++= Seq("org.apache.spark" %% "spark-sql" % "2.1.1" % "compileOnly")

// test dependencies
libraryDependencies ++= Seq("org.specs2" %% "specs2-core" % "3.9.1" % "test")

// a 'compileonly' configuation
ivyConfigurations += config("compileOnly").hide
// appending everything from 'compileOnly' to unmanagedClasspath
unmanagedClasspath in Compile ++=
  update.value.select(configurationFilter("compileOnly"))
