# A Scalable Language

The name Scala stands for "scalable language". The language is named so because it was designed to grow with the needs of the developers. It can be used for a variety of programming tasks:

- writing small scripts;
- writing large systems;
- writing web services;
- machine learning;

Scala runs on the Standard Java platform and works seamlessly with all Java libraries. Scala is a blend of object-oriented and functional programming concepts in a statically typed language. 

## A Language that grows

```scala
var capital = Map("US" -> "Washington", "France" -> "Paris")

capital += ("Japan" -> "Tokyo")

println(capital("France"))
```

The following program, sets up a map from countries to their capitals. Then we add a new country with its capital to the list, and print the capital of France.

Scala gives us a fine-grained control if we need it, because in Scala maps are not language syntax. In Scala maps are library abstractions that we can extend and adapt to our needs. 

### Growing new types

<cite>[Eric S. Raymond][1]</cite> introduced the cathedral and bazaar as a software development metaphors. The cathedral represents almost perfect building, that takes forever to built, and afterwards stays almost unchanged. The bazaar represents an dynamic structure, that is changing everyday by the peoples and the needs. In Raymond's work examples of Cathedral model are `GNU Emacs` and `GCC`, which are developed and maintained by exclusive group of developers. Examples of Bazaar model is `Linux Kernel` which code is developed publicly over internet.

`Scala` is more like a Bazaar construct, because it is designed to be extended and adapted by the people programming in it. Instead of providing all constructs that maybe needed in one *perfectly complete language*, Scala puts the tools for building such constructs into our hands. 

For example

```scala
def factorial(x: BigInt): BigInt = 
    if (x==0) 1 else x * factorial(x-1)
```

`BigInt` looks like a built-in Scala type, but it is just a class that is defined in Scala's standard library.

The approach of attempting to provide everything in one language, doesn't scale very well. Instead Scala allows programmers to extend and adapt the language in the direction that are needed, by defining easy-to-use libraries that feel like native language support.

### Growing new control constructs

Scala provides easy creation of new types, that feel like native language support. The same extension principle applies and to control structures. This kind of extensibility is used in `Akka`, which is a Scala API for *actor-based* concurrent programming.

## What makes Scala scalable

Scalability is influenced by many factors, ranging from syntax details to component abstraction constructs. The combination of object-oriented design and functional programming helps Scala in achieving scalability.

Scala goes further that all other well-known languages in fusing object-oriented design and functional programming into a uniform language design. For instance, where other languages may have objects and functions as two different concepts, in Scala a `function value is an object`. Function types are classes, that can be inherited by subclasses. 

### Object-oriented Scala

The motivation of object-oriented programming is simple: all but the most trivial programs require some sort of structure. The most straightforward way to do this is put data and operations on that data in some form of containers. The idea of object-oriented programming is to make this containers fully general, so that they can contain operations as well as data, containers themselves are values that can be stores in other containers, or passed as parameters to operations. Such containers are called **objects**.

Scala is object-oriented in a pure form: `every value is an object` and `every operation is a method call`. For example `1 + 1`, is invoking a method `+` in a class `Int`. We can define methods with operator-like names that the client of the API can then use in operator notation.

Scala is more advanced than most other languages, when it comes to composing objects. An example is Scala `trait`. A `trait` in Scala is like interface in Java, but they can also implement methods, or can have fields. `Objects` are constructed by `mixin composition`, which takes the members of a class and adds the members of a number of traits applied to the class. In this way, different aspects of classes can be encapsulated in different traits. This looks like `multiple inheritance`, but differs when it comes to the implementation details. Unlike a class, a trait can be add some new functionality to an unspecified superclass. This makes traits more *pluggable* than classes. In particular, it avoids the classical `diamond inheritance` problems of multiple inheritance, which arises when the same class is inherited via several different paths.

### Functional Scala

In addition to object-oriented Scala is also a functional language. Functional programming is guided by two main ideas. The first idea is that functions are `first-class values`. In a functional language, a function is a value of the same status as Integer or String. You can pass functions as arguments to other functions, or define a nested functions inside another function. You can also define functions without giving them a name. 

In a programming languages that functions are not first-class values, relegate them to `second-class status`. For example, in C and C++ the function pointers does not have the same status as non-functional values - *function pointers can only refer to global functions*. They do not allow us to define first-class nested functions that refer to some values in their environment. Also we cannot define unnamed function literals.

The second idea of functional programming is that operations of a program should map input values to output values rather than change the data in place. Example of this are the Java Strings immutability. In Scala strings are also immutable, invoking `string.replace` yields new string, without modifying the original value of the first string. Immutable data structures are one of the cornerstones of functional programming. The Scala interface define many more immutable types on top of those found in Java API. For instance, Scala defines immutable `list`, `tuples`, `maps` and `sets`.

Another ways of stating the second idea of functional programming is that methods should not have any **side effects**. They should communicate with the environment only by taking **arguments** and returning **results**.

[1]:https://en.wikipedia.org/wiki/The_Cathedral_and_the_Bazaar
