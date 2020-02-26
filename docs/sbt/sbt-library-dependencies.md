# Library dependencies

Library dependencies can be of two types:

- Unmanaged dependencies
- Managed dependencies

## Unmanaged dependencies

Unmanaged dependencies are the once that are manually added to the `lib` project folder. All jars in `lib` folder are also placed on the `claspath`.

By default all dependencies in `lib` go on to all `classpaths` (for compile, test, run, and console). We can specify dependency classpath for only one of actions:

<!-- tabs:start -->

#### ** Test **

```scala
Test / dependencyClasspath

```

#### ** Compile **

```scala
Compile / dependencyClasspath

```

#### ** Run **

```scala
Runtime / dependencyClasspath

```

#### ** Console **

```scala
Console / dependencyClasspath

```

<!-- tabs:end -->

## Managed dependencies

Managed dependencies are dependencies that sbt automatically downloads, sbt also tracks and matches the managed dependencies versions. To setup managed dependencies use `libraryDependencies` setting key. 

We can list all project dependencies with `show` command.  

```scala
show libraryDependencies
```

Each Scala project has the core Scala library dependencies.

```scala
sbt:Animals> show libraryDependencies
[info] * org.scala-lang:scala-library:2.12.3
```

### Adding Dependencies to the project

Declaring a dependency looks like this, where groupId, artifactId, and revision are strings:

```scala
libraryDependencies += groupID % artifactID_scalaVersion % revision
```

For example to add `liftweb.utils` dependency in sbt project file, we use:

```scala
libraryDependencies += "net.liftweb" % "lift_util_2.12.3" % "3.1.0"
```

Looking again in the dependencies we will find also `lift_util`:

```scala
sbt:Animals> show libraryDependencies
[info] * org.scala-lang:scala-library:2.12.3
[info] * net.liftweb:lift-util_2.12.3:3.1.0
```

However, we are now bound to manually specifying the correct Scala Version in the dependency artifact id. sbt has build in capabilities to track this information instead of us.

### Getting right version with sbt

Using `%% artifactId`, sbt will select and download the correct dependency version for us. Change the previous managed dependency to:

```scala
libraryDependencies += "net.liftweb" %% "lift_util" % "3.1.0"
```

We can now `reload` the project, and check again with `show` command the project dependencies.

```scala
sbt:Animals> reload
[info] Loading project definition from /Users/mariopavlov/Projects/Learn_Scala/src/sbt/library-dependencies/project
[info] Loading settings for project library-dependencies from build.sbt ...
[info] Set current project to Animals (in build file:/Users/mariopavlov/Projects/Learn_Scala/src/sbt/library-dependencies/)

sbt:Animals> show libraryDependencies
[info] * org.scala-lang:scala-library:2.12.3
[info] * net.liftweb:lift-util:3.1.0
```
Now sbt manages the proper artifact version for us. Also we can see that `artifact version` is no longer displayed by sbt.

### List of dependencies

Adding second managed dependency can be done in the same way as the first one:

```scala
libraryDependencies += "net.liftweb" %% "lift-json" % "3.1.0"
```

If our project works with only couple of dependencies this may work just fine for us. However, for bigger projects with a lot of dependencies this will not be the optimal way. 
As sbt configuration file is actually compiled to a Scala code, we can add all dependencies as a sequence or list at once.

<!-- tabs:start -->

#### ** Sequence **

```scala
libraryDependencies ++= Seq(
    "net.liftweb" %% "lift-util" % "3.1.0",
    "net.liftweb" %% "lift-json" % "3.1.0"
)
```

#### ** List **

```scala
libraryDependencies ++= List(
    "net.liftweb" %% "lift-util" % "3.1.0",
    "net.liftweb" %% "lift-json" % "3.1.0"
)
```

<!-- tabs:end -->

### Managing `revision`

In the previous example `revision` key is repeating as a string. We can remove the duplication with creating a value to hold the dependency version. We will also put the whole `libraryDependency` setting key in a scoped block. This way, the version will be available only within the block.

```scala
{
    val liftVersion = "3.1.0"

    libraryDependencies ++= Seq(
        "net.liftweb" %% "lift-util" % liftVersion,
        "net.liftweb" %% "lift-json" % liftVersion
    )
}
```

## Resolvers

Resolvers (repositories) are a set of places where sbt can look for dependencies. 

We can use again the `show` command, too see all project configuration resolvers. 

```scala
show resolvers
```

By default we have an empty resolvers lists.

```scala
sbt:Animals> show resolvers
[info] *
```

To add an additional repository:

```scala
resolvers += "repository location"
```

with the special `at` between two strings.

For example we can add Sonatype repository with:

```scala
resolvers += "Sonatype Releases Repository" at "https://oss.sonatype.org/content/repositories/Releases" 
```

## Resources

* [sbt Reference Manual - Library Dependencies](https://www.scala-sbt.org/1.x/docs/Library-Dependencies.html)
* [sbt Reference Manual - Classpaths](https://www.scala-sbt.org/1.x/docs/Classpaths.html)
