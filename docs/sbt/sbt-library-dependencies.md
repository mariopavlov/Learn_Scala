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

## Resolvers

## Resources

[sbt Reference Manual - Library Dependencies](https://www.scala-sbt.org/1.x/docs/Library-Dependencies.html)
[sbt Reference Manual - Classpaths](https://www.scala-sbt.org/1.x/docs/Classpaths.html)
