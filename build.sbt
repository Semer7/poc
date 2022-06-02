import CommonSettings.{generalSettings, githubMavenPackage}

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    generalSettings,
    name := "POC",
    version := "1.0",
    libraryDependencies ++= Seq(
      guice,
      "com.h2database" % "h2" % "1.4.199"
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    ),
    credentials += CommonSettings.credentials
  )
  .dependsOn(library)

lazy val library = project.dependsOn(dataObjects)
  .settings(generalSettings)

lazy val dataObjects = project
  .settings(generalSettings,
    publishTo := Some(githubMavenPackage),
    credentials += CommonSettings.credentials
  )