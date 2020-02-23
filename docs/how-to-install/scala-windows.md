# How to install Scala on Windows

For Windows Scoop is doing good job as a command-line installer, and can manage pretty well the installation of Java/Scala/sbt/Ammonite

## Java

As a prerequisite we need GIT.

```powershell
scoop install git
```

To install Java we need to add bucket first. Scoop provides JDK and JRE through **Scoop Java** bucket.

```powershell
scoop bucket add java
```

Then we need to install Java. Scoop supports `Oracle OpenJDK`, `Zulu JDK` and others.

<!-- tabs:start -->

#### ** Oracle OpenJDK **

```powershell
scoop install openjdk
```

#### ** Zulu JDK **

```powershell
scoop install zulu6
```

<!-- tabs:end -->

If we have multiple Java installations we can switch between versions with `reset` command. For example:

<!-- tabs:start -->

#### ** Oracle OpenJDK **

```powershell
scoop reset oraclejdk
```

#### ** Zulu JDK **

```powershell
scoop reset zulu6
```

<!-- tabs:end -->

## SBT

sbt is a build tool for Scala, Java, and more. It requires Java 1.8 or later.

<https://www.scala-sbt.org/1.x/docs/index.html>

```powershell
scoop install sbt
```

## Scala

```powershell
scoop install scala
```

## Ammonite REPL

Ammonite lets you use the Scala language for scripting purposes: in the REPL, as scripts, as a library to use in existing projects, or as a standalone systems shell.

<https://ammonite.io/>

```powershell
scoop install ammonite
```
