# Some Advanced Features

## Parameterize arrays with types

In Scala we can instantiate objects or class instances with `new` keyword. With the instantiation of the object, we can also parametrize it with values and types. For example:

```scala
val big = new java.math.BigInteger("1234567")
```

When we parametrize arrays, we need to set altogether the type of the array, and the values for each array member. For example:

```scala
val greetString = new Array[String](3)

greetString(0) = "Hello"
greetString(1) = ", "
greetString(2) = "world!\n"

for (i <- 0 to 2)
    print(greetString(i))
```

Here we can see that in Scala we access the array members with parentheses - `greetString(0)` and not square brackets like in Java - `greetString[0]`.

The previous example also demonstrates some important concept in Scala. When we define **array** with `val` in Scala, the variable always points to array of 3 string elements, and is immutable. However, the array string elements are mutable and can be changed during the life cycle.

Next lines of code in the example are iterating over the array, and the loop is performing some operation on each element, in our case we are printing the string. Also, here is demonstrated another important Scala rule. If a method takes only one parameter we can skip the *dot* and parentheses. The `to` is actually a method that takes 1 argument. So this line of code `for (i <- 0 to 2)` is actually transformed to `for (i <- (0).to(2))`. This works only if we explicitly specify the receiver, for example this will not work `println 10`, but `Console println 10` will work.

Scala does not have operator overloading, because it technically does not have operators in the traditional sense. Instead of operators, the characters such as `+ -` can be used as method names. So when we type `1 + 2`, Scala interprets it as we have written `(1).+(2)`, we are invoking on the integer value 1 method name `+` with integer parameter `(2)`.

Scala has a fewer special cases that Java. Arrays are simply instances of classes like any other class in Scala. So when we apply parentheses around one or more values, Scala compiler will transform the code into `apply()` invocation. In our previous example `greetString(i)` is transformed by the compiler for us to `greetString.apply(i)`. So accessing array members in Scala is just simply method call like any other. This principle is not restricted only to arrays, any object that is defined `apply` method, can reuse the same Scala functionality. 

Similarly, when we assign values to array object with applied parentheses, Scala compiler will transform the call into `update()` invocation. In our previous example, `greetString(0) = "Hello"` is transformed to `greetString.update(0, "Hello")`.

Scala achieves a conceptual simplicity by treating everything, from arrays to expressions as objects with methods. 

This way of initialization is very similar to Java and C code. Scala provides better way to achieve the same result:

```scala
val greetString = Array("Hello", ", ", "world!\n")
```

In behind Scala is calling a factory method named `apply()` on array object. This apply method, takes variadic arguments and returns initialized array. Here is the more verbose version of the same code:

```scala
val greetString = Array.apply("Hello", ", ", "world!\n").
```

Same as before the `greetString` array is **immutable**, but each element in the array is **mutable** and can be changed.

## Lists

One of the big ideas of functional style of programming is that methods should not have side effects. A method should compute some value and return it. Some of the benefits of that approach is that methods become less entangled, and more reusable. Another benefit is that everything that goes into and out of a method is checked by a type checker, so logical errors are more likely to pop up as type errors. Applying this philosophy to the world of objects, means to make them immutable.

Scala `arrays` explored before are mutable objects. For immutable sequence of objects Scala provides `List` class. As with the arrays the `List` class stores objects, they can be al of one type `List[String]` or can be a combination of types `List[Any]`. 

Scala `scala.List` differs from Java implementation of lists `java.util.List`, Scala implementation is immutable. Trying to update any member of the list results in error.

```scala
error: value update is not a member of List[Any]
    did you mean updated?
```

Scala `List` is designed to enable and support functional style of programming. Here is how we create a list:

```scala
val someList = List(1,2,3)
```

If we initialize the list with different types of members, Scala compiler creates a `List[Any]`.

```scala
scala> val myList = List(1, "2", "Mario")
myList: List[Any] = List(1, 2, Mario)
```

As Scala lists are immutable just as are the strings in Java, all functions that mutate somehow the list, will result in a new list with the mutated values. For example we can concatenate two lists with `:::` method. 

```scala
val oneTwo = List(1, 2)
val threeFour = List(3, 4)

val oneTwoThreeFour = oneTwo ::: threeFour
```

There is another method `::` that acts like operator and it is pronounced `cons`. It is one of the most common ones to be used on Lists, and prepends a new element in the beginning of an existing list and returns the new list. For example:

```scala
val twoThree = List(2,3)
val oneTwoThree = 1 :: twoThree
```

The following code will produce a `oneTwoThree: List[Int] = List(1, 2, 3)`.

The `cons` operator does not behave like the `+, -, *` operators, and does not invoke the `::` operator on its left operand as in `(1).*(2)`. If the method name ends in **colon**, the method is **invoked on the right operator**. So in our example what Scala compiler makes in behind actually is: `twoThree.::(1)`.

Here is what error we will receive if we change the order of the list and in integer value in the previous example:

```scala
scala> val twoThreeOne = twoThree :: 1
                                  ^
       error: value :: is not a member of Int
```

In Scala there is a shorthand way to specify an empty list with `Nil`. So we can use the `cons` operator with `Nil`, to string together non list items into an new list. However, we should not forget about the `cons` operator associativity:

```scala
val oneTwoThree = 1 :: 2 :: 3 :: Nil
```

Resulting to a new list: `oneTwoThree: List[Int] = List(1, 2, 3)`.

Class `List` does offer **append** operation written in the form of `:+`, but this operator is not used a lot, because the time that it takes to append to a list is grows **linearly with the size of the list**. `Cons` operator takes **constant** time, so it is used more often than append operation. We can efficiently build a lists with prepend operation, and then call `reverse`.

```scala
scala> val threeTwo = List(3, 2)
threeTwo: List[Int] = List(3, 2)

scala> val oneTwoThree = 1 :: threeTwo.reverse
oneTwoThree: List[Int] = List(1, 2, 3)
```

## Tuples

Another useful container object is the `tuple`. Like `lists`, `tuples` are **immutable**. Tuples are very useful in different cases, one example is if we need to return multiple objects from a method. To instantiate a new `tuple` in Scala we need to simply put the objects into parentheses separated by comas. To access the separate elements of the tuple we use the underscore dot notation with the one based index of the element. Here in as example:

```scala
val pair = (123, "Joker")
pair: (Int, String) = (123,Joker)
```

```scala
scala> println(pair._1)
123

scala> println(pair._2)
Joker
```

The `.` in the example is used to access field or method from the tuple class. In this case, we are accessing the `_1` field. The _N numbers are one-based, because starting with 1 is a tradition in other languages with statically types tuples, such as Haskell and ML.

## Sets and Maps

Because Scala aims to help us take advantage of both **functional** and **imperative** style of programming, its collections libraries make a point in differentiate between **mutable** and **immutable** collections. For example, arrays are always mutable, and lists immutable. Scala also provides mutable and immutable alternatives for maps and sets, but uses the same simple name for both. For sets and maps, Scala models mutability in the class hierarchy.

For example, the Scala API contains a base trait for sets. 

