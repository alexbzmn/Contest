lazy val root = (project in file(".")).
  settings(
    organization := "com.alexbzmn",

    name := "contest",

    version := "0.1.0-SNAPSHOT",
    libraryDependencies ++= Seq(
      "ch.qos.logback" % "logback-classic" % "1.0.0" % "runtime"
    )

  )