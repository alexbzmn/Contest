lazy val root = (project in file(".")).
  settings(
    organization := "com.alexbzmn",

    name := "contest",
    scalaVersion := "2.12.2",
    version := "0.1.0-SNAPSHOT",
    scalaSource in Compile := baseDirectory.value / "src/scala",
    excludeFilter in unmanagedSources := HiddenFileFilter || "java",
    libraryDependencies ++= Seq(
      "ch.qos.logback" % "logback-classic" % "1.0.0" % "runtime"
    )
  )