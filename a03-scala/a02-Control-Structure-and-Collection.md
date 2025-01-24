# Content
- [1-Conditional-Statment](#1-Conditional-Statment)   
	- [1-1-if-Expression](#1-1-if-Expression)   
	- [1-2-Nested-if-Expression](#1-2-Nested-if-Expression)   
	- [1-3-Return-Value-and-Type](#1-3-Return-Value-and-Type)   
	- [1-4-Idiomatic-Conditional-Initialization](#1-4-Idiomatic-Conditional-Initialization)   
- [2-Loops](#2-Loops)
	- [2-1-while-Loop](#2-1-while-Loop)
	- [2-2-do-while-Loop](#2-2-do-while-Loop)
	- [2-3-for-Loop](#2-3-for-Loop)
	- [2-4-foreach-Loop](#2-4-foreach-Loop)
	- [2-5-Breaking-Out-of-Loops](#2-5-Breaking-Out-of-Loops)
	- [2-6-Summary](#2-6-Summary)
- 

---

#### Day-2_Control-Structures-and-Collections
- Conditionals (`if`, `else`, `match`)
- Loops (`for`, `while`)
- Introduction to collections (Lists, Sets, Maps)
- Basic operations on collections
---

# 1-Conditional-Statment

The `if-else` construct in Scala is one of the most fundamental conditional constructs, similar to those in other programming languages like Java or C++. It allows us to execute certain blocks of code based on a condition's value. In this explanation, we will cover how conditional expressions work in Scala.

## 1-1-if-Expression

The basic syntax of an `if` expression in Scala looks like this:

```scala
if (<condition expression>) {
  <expression>
} else {
  <expression>
}
```

- **Condition Expression**: The condition expression evaluates to a boolean value (`true` or `false`). 
- **Execution Flow**:
  - If the condition is `true`, the first block of code inside the `if` is executed.
  - If the condition is `false`, and there is an `else` block, the code inside the `else` is executed.

The `else` part is optional, meaning it is perfectly valid to have an `if` expression without an `else`.

**Example**:

```scala
def max(a: Int, b: Int): Unit = {
  var max: Int = a

  if (b > a) {
    max = b
  }

  printf("Maximum is %d", max)
}
/* Here:
- We define a function `max` to print the maximum of two integers `a` and `b`.
- Initially, `max` is assigned the value of `a`.
- If `b` is greater than `a`, the value of `b` is assigned to `max`.
- Finally, the value of `max` is printed. */
```

Another example using `if` with `else`:

```scala
if (10 % 2 == 0) {
  printf("Number is even")
} else {
  printf("Number is odd")
}
```

Since 10 is divisible by 2, the output is:

```
Number is even
```

- **Note**: Curly braces `{}` are optional if there is only one statement in the `if` or `else` block. However, using them is recommended by the Scala Style Guide for better readability.

## 1-2-Nested-if-Expression

You can nest `if-else` expressions to handle multiple conditions:

```scala
val number = 10
if (number == 0) {
  printf("Number is zero")
} else if (number > 100) {
  printf("Number is greater than 100")
} else {
  printf("Number is %d", number)
}
/*
===================================================
OUTPUT:
---------------------------------------------------
Number is 10
===================================================
Here:
- The value of `number` is 10.
- The first two conditions (`number == 0` and `number > 100`) evaluate to `false`.
- Therefore, the `else` block is executed, producing:
*/
```

## 1-3-Return-Value-and-Type

Scala's `if` expression is different from other languages in that it always returns a value.

- The value of the `if` expression is the value of the last executed statement within the `if` or `else` block.

**Example**:

```scala
def max(a: Int, b: Int): Int = {
  if (b > a) {
    b
  } else {
    a
  }
}
```

Here:
- The `if` expression directly returns the maximum value between `a` and `b`.
- The return type is `Int`, as both branches return `Int`.

- **Type Inference**: The return type of an `if` expression without an `else` is `Any`, since `Any` is the supertype of all types in Scala.

**Example in Scala REPL**:

```scala
scala> val result = if (false) "failed"
result: Any = ()
```

- <span style="background:#fff88f">The return value is `()` (the unit value), and its type is `Any`.</span>

## 1-4-Idiomatic-Conditional-Initialization

In Scala, it's idiomatic to use an <span style="background:#fff88f">`if` expression to initialize variables conditionally</span>. This approach is more concise and makes use of `val` instead of `var`, promoting immutability and enhancing code readability.

**Example**:

```scala
val max: Int = if (10 > 100) {
  10
} else {
  100
}
```

Here:
- The value of `max` is initialized with 100, as 10 is not greater than 100.

Scala does not have a ternary operator like Java, as the `if` expression already returns a value, making a ternary operator redundant.   

This concludes our overview of conditional statements in Scala. Would you like to dive deeper into any of these topics?   
[Click here to check out the code](scala-eclipse-ws/scalaTutorials/src/main/scala/com/vdubey/a02_Control_Structure_and_Collection/a01_Conditions.scala)   

----

# 2-Loops

Check out the below blog post from Rock the JVM to not use the loop in Scala.   
[Click here](https://blog.rockthejvm.com/scala-looping/)  -->  https://blog.rockthejvm.com/scala-looping/   

## 2-1-while-Loop

The `while` loop is one of the most basic loop constructs. It executes a block of code as long as the specified condition remains true.   

**Syntax**:

```scala
while (condition) {
  // code to execute

/*
* ========================================================================
* Condition: A boolean expression that is checked before each iteration.
* If it's true,the loop runs; otherwise, it stops.
* This loop prints numbers from 0 to 4. 
* It runs until the value of `i` is no longer less than 5.
* ========================================================================
* Example
* ========================================================================
*/

var i = 0
while (i < 5) {
  println(i)
  i += 1
}
}
```

## 2-2-do-while-Loop

The `do-while` loop is similar to the `while` loop, except the condition is checked after the code block is executed. This ensures that the loop executes at least once, regardless of the condition.   

**Syntax**:

```scala
do {
  // code to execute
} while (condition)

/*
* ========================================================================
* The loop prints numbers from 0 to 4, similar to the `while` loop, 
* but the code block is guaranteed to execute at least once, 
* even if the condition is false initially.
* ========================================================================
* Example
* ========================================================================
*/

var i = 0
do {
  println(i)
  i += 1
} while (i < 5)
```


## 2-3-for-Loop

The `for` loop in Scala is more flexible and powerful than traditional `for` loops in other languages. It can iterate over a range, a collection, or even include filters and guards.   

**Syntax**
```scala
for (i <- start to end) {
  // code to execute
}


// This loop iterates over a range of numbers from `start` to `end`, inclusive.
// Example:

for (i <- 1 to 5) {
  println(i)
}
// This prints numbers from 1 to 5. 
// Alternatively, you can use the `until` keyword to exclude the last value in the range:




for (i <- 1 until 5) {
  println(i)
}
// This prints numbers from 1 to 4, as `5` is excluded.




// Iterating Over Collections
// The `for` loop can also be used to iterate over collections such as lists, arrays, etc.
// Example:
val fruits = List("apple", "banana", "cherry")
for (fruit <- fruits) {
  println(fruit)
}
// This prints each fruit in the list.




// Using Guards (Filters)
// You can filter elements within a `for` loop by adding a condition (guard) using `if`.
// Example:
for (i <- 1 to 10 if i % 2 == 0) {
  println(i)
}
//This prints only even numbers between 1 and 10.





// Nested `for` Loops
// Scala also supports nested `for` loops, allowing multiple iterators in a single loop.
// Example:
for (i <- 1 to 3; j <- 1 to 3) {
  println(s"i = $i, j = $j")
}
// This produces pairs of `i` and `j` values, creating a grid-like iteration.





// Yielding Values (`for` Comprehension)
// In Scala, `for` loops can return values using the `yield` keyword. This is called a `for comprehension`.
// Example:
val squares = for (i <- 1 to 5) yield i * i
println(squares)
// This creates a collection of squares (e.g., `Vector(1, 4, 9, 16, 25)`) as the result of the loop.
```

## 2-4-foreach-Loop

Scala collections have a `foreach` method that applies a function to each element in the collection. It is similar to the `for` loop but is used as a method on collections.   

**Example**:

```scala
val nums = List(1, 2, 3, 4, 5)
nums.foreach(println)
```

- This prints each element of the list `nums`.

## 2-5-Breaking-Out-of-Loops

Scala does not have traditional `break` and `continue` statements like Java or Python. However, you can break out of loops using the `Breaks` object from the `scala.util.control` package.   

**Example**:

```scala
import scala.util.control.Breaks._

breakable {
  for (i <- 1 to 10) {
    if (i == 5) break  // Exits the loop when i equals 5
    println(i)
  }
}
```

- The loop prints numbers from 1 to 4, then exits when `i` equals 5.   

## 2-6-Summary

- **`while` Loop**: Repeats as long as the condition is true.
- **`do-while` Loop**: Executes at least once before checking the condition.
- **`for` Loop**: Versatile loop that can iterate over ranges, collections, or with filters, and can return collections via `yield`.
- **`foreach`**: Applies a function to each element of a collection.
- **Breaking Loops**: Use the `Breaks` object to break out of loops in Scala.

-------------
