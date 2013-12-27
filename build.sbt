scalaVersion := "2.10.4-RC1"

libraryDependencies := Seq(
  "org.scala-lang" % "scala-library" % "2.10.4-RC1",
  // "org.scala-lang" % "scala-reflect" % "2.10.4-RC1", // does NOT fix the problem
  "com.typesafe.slick" % "slick_2.10" % "2.0.0-RC1"
)
