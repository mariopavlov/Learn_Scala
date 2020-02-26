name := "Animals"

version := "1.0.0"

organization := "zoo"

scalaVersion := "2.12.3"

resolvers += "Sonatype Releases Repository" at "https://oss.sonatype.org/content/repositories/Releases"

{
    val liftVersion = "3.1.0"

    libraryDependencies ++= Seq(
        "net.liftweb" %% "lift-util" % liftVersion,
        "net.liftweb" %% "lift-json" % liftVersion
    )
}
