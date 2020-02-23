# Scala Installations

## Windows

For Windows Scoop is doing good job as a command-line installer, and can manage pretty well the installation of Java/Scala/sbt/Ammonite

### Java

As a prerequisite we need GIT.
`scoop install git`

To install Java we need to add bucket first. Scoop provides JDK and JRE throught **Scoop Java** bucket.

`scoop bucket add java`

Then we need to install Java. Scoop supports `Oracle OpenJDK`, `Zulu JDK` and others.
- Oracle OpenJDK
`scoop install openjdk`

- Zulu JDK
`scoop install zulu6`

If we have multiple Java installations we can swtich between versions with `reset` command. For exmaple:
`scoop reset oraclejdk`
and
`scoop reset zulu6`

### SBT

sbt is a build tool for Scala, Java, and more. It requires Java 1.8 or later.
https://www.scala-sbt.org/1.x/docs/index.html

`scoop install sbt`

### Scala

`scoop install scala`

### Ammonite REPL

Ammonite lets you use the Scala language for scripting purposes: in the REPL, as scripts, as a library to use in existing projects, or as a standalone systems shell.
https://ammonite.io/

`scoop install ammonite`

## MacOS
