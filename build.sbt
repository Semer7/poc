lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := "POC",
    version := "1.0",
    scalaVersion := "2.13.8",
    libraryDependencies ++= Seq(
      guice,
      "com.h2database" % "h2" % "1.4.199"
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )
  .dependsOn(library)

lazy val library = project.dependsOn(dataObjects)

lazy val dataObjects = project
  .settings()