lazy val root = (project in file(".")).
  settings(
    organization := "com.alexbzmn",

    name := "contest",
    scalaVersion := "2.12.2",
    version := "0.1.0-SNAPSHOT",
    scalaSource in Compile := baseDirectory.value / "src/main/scala",
    javaSource in Compile := file("some/path/that/doesnt/exist"),
    libraryDependencies ++= Seq(
      "ch.qos.logback" % "logback-classic" % "1.0.0" % "runtime"
    )
  )