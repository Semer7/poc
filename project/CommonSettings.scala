import sbt.Keys.{externalResolvers, organization, scalaVersion}
import sbt._

object CommonSettings {

  val mavenCredentials = Credentials (
    "GitHub Package Registry",
    "maven.pkg.github.com",
    "Semer7",
    System.getenv("GITHUB_TOKEN")
  )

  val generalSettings: Seq[Def.Setting[String]] = Seq(
    organization := "ua.semer7",
    scalaVersion := "2.13.8"
  )

  val resolvers = externalResolvers += "GitHub semer7 Maven Repo" at "https://maven.pkg.github.com/semer7/poc"

  val githubMavenPackage = "GitHub semer7 Maven Repo" at "https://maven.pkg.github.com/semer7/poc"
}
