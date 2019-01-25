import mill._, scalalib._

object hello extends SbtModule {
  def scalaVersion = "2.12.7"
  def artifactName = "hello"
  def mainClass = Some("org.primetalk.scala101.Day2")
}

