# How to install Scala on MacOS

On MacOS I prefer to use SDKMAN, to manage all java sdk versions.

## Java

Then we need to install Java. SDKMAN supports `Oracle OpenJDK`, `Zulu JDK` and others.

<!-- tabs:start -->

#### ** Oracle OpenJDK **

```zsh
sdk install java 11.0.2-open
```

#### ** Zulu JDK **

```zsh
sdk install java 11.0.6-zulu
```

<!-- tabs:end -->

To display the current version of Java we can use:

```zsh
sdk current java
```

We can list all installed or available for installation Java versions with:

```zsh
sdk list java
```

If we have multiple Java installations we can switch between versions with `sdk default java` command. For example:

<!-- tabs:start -->

#### ** Oracle OpenJDK **

```zsh
sdk default java 11.0.2-open
```

#### ** Zulu JDK **

```zsh
sdk default java 11.0.6-zulu
```

<!-- tabs:end -->

## SBT

```zsh
sdk install sbt
```

## Ammonite-REPL

And finally we can install Ammonite-REPL. I have used brew to install it.

```zsh
brew install ammonite-repl
```

## Resources

* [SDKMAN](https://sdkman.io/jdks)

* [sbt](https://www.scala-sbt.org/1.x/docs/Installing-sbt-on-Mac.html)

* [Ammonite-REPL](https://ammonite.io/)

* [Scala](https://scala-lang.org/download/)
