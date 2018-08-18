name := "data_injector"

version := "0.1"

scalaVersion := "2.12.6"

val elastic4sVersion  = "6.3.6"
val akkaHttpVersion   = "10.1.3"
val akkaStreamVersion = "2.5.14"
val scalaTestVersion  = "3.0.5"

libraryDependencies ++= Seq(
  // Elastic4s
  "com.sksamuel.elastic4s"  %% "elastic4s-core"       % elastic4sVersion,
  "com.sksamuel.elastic4s"  %% "elastic4s-http"       % elastic4sVersion,

  // Akka
  "com.typesafe.akka"       %% "akka-http"            % akkaHttpVersion,
  "com.typesafe.akka"       %% "akka-stream"          % akkaStreamVersion,

  // Testing modules
  "org.scalatest"           %% "scalatest"            % scalaTestVersion % Test,
  "com.sksamuel.elastic4s"  %% "elastic4s-testkit"    % elastic4sVersion % Test,
  "com.sksamuel.elastic4s"  %% "elastic4s-embedded"   % elastic4sVersion % Test
)