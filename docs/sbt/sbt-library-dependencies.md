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

Managed dependencies are dependencies that sbt automatically downloads, sbt also tracks and matches the managed dependencies versions. `libraryDependencies` is the setting key. 

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

For example we can add `liftweb.utils` managed dependency as:

```scala
libraryDependencies += "net.liftweb" % "lift_util_2.12.3" % "3.1.0"
```

Now if we take a look again at the dependencies we will find also `lift_util`:

```scala
sbt:Animals> show libraryDependencies
[info] * org.scala-lang:scala-library:2.12.3
[info] * net.liftweb:lift-util_2.12.3:3.1.0
```

However, we are now bound to manually specifying the correct Scala Version in the dependency artifact id. sbt can also take care instead of us to download the correct dependency version.

### Getting right version with sbt

If we use `%% artifactId`, sbt will select and download the correct dependency version for us. So we can change the previous managed dependency to:

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

## Resolvers

Resolvers are a set of places where sbt can look for dependencies. 

When executing the `show` command, we can see all configure resolvers. 

```scala
show resolvers
```

By default we have an empty resolvers lists.

```scala
sbt:Animals> show resolvers
[info] *
```

Adding a repository for a resolver where a library lives.







```scala
resolvers += "Sonatype Releases Repository" at "https://oss.sonatype.org/content/repositories/Releases" 
```

```scala
sbt:Animals> show libraryDependencies
[info] * org.scala-lang:scala-library:2.12.3
[info] * net.liftweb:lift_util_2.12.3:3.1.0
```



```scala
sbt:Animals> show libraryDependencies
[info] * org.scala-lang:scala-library:2.12.3
[info] * net.liftweb:lift_util:3.1.0
```

## Resources

[sbt Reference Manual - Library Dependencies](https://www.scala-sbt.org/1.x/docs/Library-Dependencies.html)
[sbt Reference Manual - Classpaths](https://www.scala-sbt.org/1.x/docs/Classpaths.html)
