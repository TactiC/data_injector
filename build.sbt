name := "data_injector"

version := "0.1"

scalaVersion := "2.11.8"

val elastic4sVersion = "6.2.7"

libraryDependencies ++= Seq(
  // Elastic4s
  "com.sksamuel.elastic4s" %% "elastic4s-core" % elastic4sVersion,
  "com.sksamuel.elastic4s" %% "elastic4s-http" % elastic4sVersion,

  // Akka
  "com.typesafe.akka" %% "akka-http"   % "10.1.1",
  "com.typesafe.akka" %% "akka-stream" % "2.5.11",

  // Testing modules
  "org.scalatest" %% "scalatest" % "3.0.5" % Test,
  "com.sksamuel.elastic4s" %% "elastic4s-testkit" % elastic4sVersion % Test,
  "com.sksamuel.elastic4s" %% "elastic4s-embedded" % elastic4sVersion % Test

)