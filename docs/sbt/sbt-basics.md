# SBT Basics

Scala sbt is a build tool for Scala written in Scala, but can build Java files as well.

Build definition and source code connected with this documentation:
[sbt basics](../src/sbt/basics/build.sbt)

## Compiler Bridge Package

Because sbt itself is written in Scala, sbt compiles build definition with one version of Scala and potentially compiles the source code with different Scala version. To support this sbt has a bridge packages that can involve different Scala versions.

The first time we invoke `compile` command sbt build the bridge for us.

For example:

```powershell
[info] Non-compiled module 'compiler-bridge_2.12' for Scala 2.12.6. Compiling...
```

## Build definition

Build file `build.sbt` is the basic file name for any sbt definition for a project that sbt will manage.

There are different properties that we can set in the build definition file. Here are the basic ones:

- name: `name := "Animals"`;
- organization: `organization := "farm"`;
- version: `version := "1.0.0"`;
- scalaVersion: `scalaVersion := 2.12.3`. This specifies the version of Scala that will be used to build the application. If this value is not specified, sbt will use the latest available scala version;

Operator `:=` does not simply assign a value to an operator in Scala. `name` is a special value defined by sbt.

When running `sbt` command from the command prompt, `sbt` compiles the build file as actual `Scala` file.

## Commands

### Compile

To compile an project we run `compile` command.

We can also prefix any command with `~compile`, and the command will be automatically re-executed whenever one of the source files within the project is modified.

### Run

The `run` and `runMain` actions provides a mean for running user code in the same virtual machine as sbt.

### runMain

The `runMain` is an variant of `run` action, that takes an additional arguments. The additional arguments allows us to specify the fully qualified class name of the main class that we need to run.

So for example if we want to run the `Run` singleton object from `animals` package we need to execute the following command: `runMain animals.Run`

### Reload

In case if the [build definition](#build-definition) file is changed, we can use the `reload` command.

### Inspect build environment

`sbt` has couple of commands that allows expecting the build environment. `Show` command is one of them.

For example we can ask for:

- `show name`: Get the name of the project;
- `show version`: Get the version of the project;
- `show organization`: Get the organization;
- `show scalaVersions`: Get scala version;
- `show sources`: Get all source files that `sbt` uses for the build;

## Build directories

### project

Project directory holds the `sbt` **compiled definition** file: `project/target/`.

### target

Target is the place where `sbt` puts the **compiled versions**(class files) and the **jar archive** of the `scala source code`.

## sbt Project organizations

`sbt` supports out of the box the default `Maven` way structuring of files.

### 3-layer system

- `src`: Source folder;
- `src/main`: Main directory is where main artifacts stays. Source files that are relevant to executing applications;
- `src/test`: All tests files live here;
- `main/scala`: Programming language that the source files will be written in;
- `main/scala/animals`: Usually we create directories for each package in the source code;

### sbt File Tracking

`sbt` tracks the files that are built in the past. However, if we move the files `sbt` will lose the track of those files and will recompile them.

## Resources

[sbt Reference Manual](https://www.scala-sbt.org/1.x/docs/index.html)
