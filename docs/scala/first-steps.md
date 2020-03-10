# First Steps in Scala

## Scala Interpreter

Scala interpreter is an interactive *shell* for writing and executing Scala expressions and programs. To invoke Scala interpreter we can either directly run `scala`, from powershell or bash, or through sbt.

Here is an example of direct invoking:

```powershell
$ scala
Welcome to Scala 2.13.1 (OpenJDK 64-Bit Server VM, Java 11.0.2).
Type in expressions for evaluation. Or try :help.

scala >
```

## Variables

Scala has two variants of variables: `val` and `var`.

A `val` is similar to `final` variable in Java, and it is immutable. Once initialized, it cannot be changed through the life of the program.

A `var` is similar to the standard Java variable declaration. It is a mutable variable, and can be changed during the lifetime of the program.

```powershell
scala> val msg = "Hello, world!"
msg: String = Hello, world!
```

This statement introduces `msg` as a name for the string value `"Hello, world!"`. It is of type `java.lang.String`.

We do not need to explicitly define the `String` type in Scala. This is due to the Scala ability to figure out the type of the expressions - `type inference`.

If we need we can also define variables in Scala `explicitly`. In contrast to Java, explicit definition in Scala happens after the variable name: `val msg: java.lang.String`.

```powershell
scala> val msg2: java.lang.String = "Hello again, world!"
msg2: String = Hello again, world!
```

## Functions

In Scala function definitions start with `def`. Then we type the function name, in this case `max`, followed by a list of function parameters, separated by commas. For each parameter, we must write the type after the colon `:`, because Scala compiler cannot infer the function parameter types. After the closing parameter parentheses, we can optionally define the result type. In this case it is `: Int`. The result type of the functions in Scala is optional, but it is a good practice to write it. Then it follows the body of the function.

```scala
def max(x: Int, y: Int): Int {
    if (x > y) 
        x
    else 
        y
}
```

The equal sign that precedes the body of the functions hints that in functional world view, a function defines an expression that results in a value. 

A function that returns no result is of type `Unit`, `Unit` type is mapped to Java `void`. Methods with the result of type of `Unit` are executed only for their **side effects**.

## While Loop

```scala
var i = 0;
while (i < args.length) {
    println(args(i))
    i += i;
}
```

The example above starts with declaring `var i`, and initializing it to 0. The Scala type inference gives variable i type of `scala.Int`. Next statement is while, which executes until the boolean expression inside the parentheses `(i < args.length)` is `true`. The `while` statement will execute the following line (if `{ }` are missing), or the `block` after it. In our case, it will execute `println` as long as the statement is `true`. The last row of the while block: `i += i` is very important, because it will eventually **terminate** the `while` loop. If we forget this increment step, our loop will be running infinite times, and will print only the first program argument. 

In Scala, just as in Java it is important to put the parentheses around the boolean expression. For example `if 10 > 20` or `while i < args.length` are not valid statements.

> **Note** The while loop example, does not demonstrate the best Scala example of iterating.

## foreach loops

The previous style in the while loop is the so called **imperative** loop style, which is usually found in languages such as *C, C++, Java*. In the imperative style we give one imperative command at a time, iterate with loops, and often mutate state shared between different functions. In Scala we can write imperative styled loops, but we can also use the so called **functional** style. The functional style is preferred over the imperative, and most of the Scala programmers will use it. We can say it is best practice to use the functional style.

As functions are first class constructs in Scala and in functional programming, we can rewrite the previous `while` loop construct with:

```scala
args.foreach(arg => println(arg))
```

Here we are calling the `foreach` function on `args`. The `foreach` expects in a function as a parameter, and in our case we pass in `function literal`.

> **Note** `for` loop is also available in Scala. In effort to guide us to a more functional direction, only an imperative `for` is available, called `for expressions`.
> 
> Here is an example:
> ```scala
> for (arg <- args)
>   println(arg)
> ```
