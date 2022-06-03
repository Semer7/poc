import CommonSettings.{generalSettings, githubMavenPackage}
import com.typesafe.sbt.packager.docker.DockerChmodType.UserGroupWriteExecute
import com.typesafe.sbt.packager.docker.DockerPermissionStrategy.CopyChown

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
    )
  )
  .dependsOn(library)

lazy val library = project
  .dependsOn(dataObjects)
  .settings(generalSettings)

lazy val dataObjects = project
  .settings(
    generalSettings,
    publishTo := Some(githubMavenPackage),
    credentials += CommonSettings.mavenCredentials
  )

enablePlugins(DockerPlugin)
enablePlugins(AshScriptPlugin)

dockerChmodType := UserGroupWriteExecute
dockerPermissionStrategy := CopyChown
dockerBaseImage := "amazoncorretto:11-alpine"
dockerRepository := Some("https://docker.pkg.github.com/semer7/poc")
