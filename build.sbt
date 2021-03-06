lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """circle-ci-integration""",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.1",
    libraryDependencies ++= Seq(
      guice,
      "com.h2database" % "h2" % "1.4.199",
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    ),
    envVars in Test := Map("PLAY_SECRET" -> "just a secret value for test")
  )
