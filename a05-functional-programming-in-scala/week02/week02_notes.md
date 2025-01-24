# Lecture-2-1-Higher-Order-Fuction
- Functional languages treat functions as *first-class values.*
- This means that, like any other value, a function can be passed as a parameter and returned as a result.
- This provides a flexible way to compose programs.
- <span style="background:#b1ffff">Functions that take other functions as parameters or that return functions as results are called higher order function</span>

```scala  
// take the sum of integer between a and b:  
def sumInts(a: Int, b: Int): Int =  
  if (a>b) 0 else a + sumInts(a + 1, b)  
  
sumInts(2, 5)  
  
  
  
// Take the sum of cube of all the integers between a and b:  
def cube(x: Int): Int = x * x * x  
  
def sumCubes(a: Int, b: Int): Int =  
  if (a>b) 0 else a + sumCubes(a + 1, b)  
  
sumCubes(2, 5)  
  
  
  
// Sum of factorial between all integers between a and b  
def fact(a: Int): Int = if (a == 0) 1 else a * fact(a-1)  
def sumFactorials(a: Int, b: Int): Int =  
  if (a >b) 0 else fact(a) + sumFactorials(a + 1, b)  
  
sumFactorials(2, 5)  
  
  
  
// in all above example we were passing the value not function so lets try to find some common thing  
// we are seeing every place we are performing sum operation  
// SUMMING WITH HIGHER ORDER FUNCTION  
// Defining the function which takes function as parameters and  
// perform the sum on the function between all integers a and b  
def sum(f: Int => Int, a: Int, b:Int): Int =  
  if (a>b) 0  
  else f(a) + sum(f, a + 1, b)  
  
// define function which we are going to pass as parameters  
def id(x: Int): Int = x  
def cube(x: Int): Int = x * x * x  
def fact(x: Int): Int = if (x==0) 1 else x * fact(x-1)  
  
// Let's use the sum function for adding the all integers between a and b  
def sumIntsNew(a: Int, b: Int)                = sum(id, a,b)  
def sumCubesNew(a: Int, b: Int): Int          = sum(cube, a, b)  
def sumFactorialsNew(a: Int, b: Int): Int     = sum(fact, a, b)  
  
// calling above functions:  
sumIntsNew(2, 5)  
sumCubesNew(2, 5)  
sumFactorialsNew(2, 5)
```

## 2-1-1-Function-Type
The type `A => B` is the type of a function that takes an argument of type A and return a result of type B.   
So, `Int => Int` is the type of functions that map integers to integers.


## 2-1-2-Anonymous-Function
- Passing function as parameters leads to the creation of many small functions.
	- Sometimes it is tedious to have to define (and name) these function using def
- Compare to string: We do not need to define a string using def. Instead of

```scala
def str = "abc"; println(str)

we can direcly write
println("abc")
```

- because strings exists as literals. Analogously we would like function literals, which let us write a function without giving it a name
- These are called *Anonymous functions*

Example: we can define the cube function without its name

```scala
(x: Int) => x * x * x
```

Here,   
- `(x: Int)` is the <font color="#ff0000">parameter</font> of the function, and `x * x * x` is it's <font color="#ff0000">body</font>.
- The type of parameters can be omitted if it can be inferred by the complier from the context.
- `=>` is the <font color="#ff0000">separator</font> between parameter and function body.
- If there are several parameters, they are separated by commas:

```scala
(x: Int, y: Int) => x + y
```

**Summation with Anonymous functions**   
```scala
// sum will take a function, perform the operation for the function and summation between integer a and b
def sum(f: Int => Int, a: Int, b:Int): Int =  
  if (a>b) 0  
  else f(a) + sum(f, a + 1, b)
  
// Using anonymous functions, we can write the sums in shorter way:  
// In this way no need to explicitly defines the id, cube and fact functions.
def sumIntsUsingAF(a: Int, b: Int): Int           = sum(x => x, a, b)  
def sumCubesUsingAF(a: Int, b: Int): Int          = sum(x => x*x*x, a, b)  
  
// calling above function  
sumIntsUsingAF(2, 5)  
sumCubesUsingAF(2, 5)


// OUTPUT IN REPL
def sumIntsUsingAF(a: Int, b: Int): Int
def sumCubesUsingAF(a: Int, b: Int): Int

val res6: Int = 14
val res7: Int = 224
```


**EXERCISE**   
```scala
// Write a tail recursive version of sum function which takes a function,  
// perform operation on function and summation of integer between a and b  
def SumTailRec(f: Int => Int, a: Int, b: Int) : Int = {  
  def loop(a: Int, acc: Int): Int =   
    if (a > b) acc  
    else loop(a+1, acc + f(a))  
  loop(a, 0)  
}  
  
// here, `x => x` and `x => x*x*x` is anonymous function // which returns x itself and cubes of x respectively.  
def sumIntsUsingAFWithTailRec(a: Int, b: Int): Int     = SumTailRec(x => x, a, b)  
def sumCubesUsingAFWithTailRec(a: Int, b: Int): Int    = SumTailRec(x => x*x*x, a, b)  
  
// calling above function:  
sumIntsUsingAFWithTailRec(2,5)  
sumCubesUsingAFWithTailRec(2, 5)

// OUTPUT IN REPL
def sumIntsUsingAFWithTailRec(a: Int, b: Int): Int
def sumCubesUsingAFWithTailRec(a: Int, b: Int): Int

val res8: Int = 14
val res9: Int = 224
```

# Lecture-2-2-Currying
### function take a function and return function
```scala
def sum(f: Int => Int): (Int, Int) => Int ={  
  def sumF(a: Int, b: Int): Int =  
    if (a > b) 0  
    else f(a) + sumF(a + 1, b)  
  sumF  
}  
//  
//// sum is now a function that returns another functions.  
//// The returned function sumF applies the given function parameter f and sums the results.  
//  
def sumInts         = sum(x => x)  
def sumCubes        = sum(x => x*x*x)  
  
sumInts(2, 5)  
sumCubes(2, 5)
```

**Multiple parameter list**   
The definition of functions that return functions is so useful in functional programming that there is a special syntax for it in Scala.   
For example, the following definition of sum is equivalent to the one with the nested sum function. but shorter.   

```scala
def sum(f: Int => Int)(a: Int, b: Int) : Int =  
  if (a>b) 0 else f(a) + sum(f)(a + 1, b)  
  
sum(x=> x*x*x) (2, 5)
```

**Explanation**   
Let's break down the given Scala code line by line to understand how it works.
1. **Function Definition:**
   - `def sum(f: Int => Int)(a: Int, b: Int): Int =`:
     - `sum` is a function that takes two sets of parameters:
       - The first parameter list contains a function `f` of type `Int => Int`, meaning it takes an `Int` as input and returns an `Int`.
       - The second parameter list contains two integers, `a` and `b`.
     - The function returns an integer `Int`.

2. **Function Logic:**
   - `if (a > b) 0 else f(a) + sum(f)(a + 1, b)`:
     - This is a recursive function.
     - **Base Case**: If `a` is greater than `b`, the function returns `0`. This is the termination condition for the recursion.
     - **Recursive Case**: If `a` is not greater than `b`, the function does the following:
       - It applies the function `f` to `a` (i.e., `f(a)`).
       - Then, it adds this result to the result of a recursive call to `sum(f)(a + 1, b)`, which effectively increments `a` by 1 and continues the process until `a > b`.

3. **Example Usage:**

```scala
sum(x => x * x * x)(2, 5)
```

- Here, the `sum` function is called with the following parameters:
  - `f = x => x * x * x`: This is a lambda function that takes `x` as input and returns `x` cubed (`x³`).
  - `a = 2` and `b = 5`: These are the lower and upper bounds for the summation.

**Step-by-Step Execution:**   
1. **First Call:** `sum(x => x * x * x)(2, 5)`
   - `a = 2`, `b = 5`
   - Since `2` is not greater than `5`, calculate `f(2)`, which is `2 * 2 * 2 = 8`.
   - Then, call `sum(f)(3, 5)`.

2. **Second Call:** `sum(f)(3, 5)`
   - `a = 3`, `b = 5`
   - Calculate `f(3)`, which is `3 * 3 * 3 = 27`.
   - Then, call `sum(f)(4, 5)`.

3. **Third Call:** `sum(f)(4, 5)`
   - `a = 4`, `b = 5`
   - Calculate `f(4)`, which is `4 * 4 * 4 = 64`.
   - Then, call `sum(f)(5, 5)`.

4. **Fourth Call:** `sum(f)(5, 5)`
   - `a = 5`, `b = 5`
   - Calculate `f(5)`, which is `5 * 5 * 5 = 125`.
   - Then, call `sum(f)(6, 5)`.

5. **Fifth Call:** `sum(f)(6, 5)`
   - `a = 6`, `b = 5`
   - Since `6` is greater than `5`, return `0`.

**Result Calculation:**   
Now, the results are added together as the recursive calls unwind:

- `125 + 64 + 27 + 8 + 0 = 224`

So, `sum(x => x * x * x)(2, 5)` returns `224`, which is the sum of the cubes of the integers from `2` to `5`.


## Currying
Currying is a way of breaking down a function that <font color="#f79646">takes multiple arguments into a series of functions that each take one argument</font>. Instead of passing all arguments at once, you pass them one at a time, with each step returning a new function that takes the next argument.

```scala
def function_name(argument1) = (argument2) => operation // or,
def function_name(arg1)(arg2):ReturnType = operation
```

Example:   
```scala
def Add(a: Int)(b: Int): Int = {a + b}  
Add(2)(5)  
  
// currying using Lambda function  
def lemAdd(a: Int)=(b: Int) => a +  b  
lemAdd(2)(5)

// OUTPUT IN WORKSHEET======================================
// def Add(a: Int)(b: Int): Int
// val res10: Int = 7
// 
// def lemAdd(a: Int): Int => Int
// val res11: Int = 7
```

-----------


# Lecture-2-3-Example-Finding-Fixed-Points

- A number x ix called a fixed point of a function f if  
- `f(x) = x`
- or some functions f we can locate the fixed points by starting with an initial estimate and then by applying f in a respective way.   
- `x, f(x), f(f(x)), f(f(f(x))), ...`
- until the value does not vary anymore ( or the changes is sufficiently small)


```scala
def isCloseEnough(x: Double, y: Double, tolerance: Double = 0.0001): Boolean = {  
  math.abs(x - y) / x < tolerance  
}  
  
// Fixed-point function, iterates until the difference between successive values is small enough  
def fixedPoint(f: Double => Double)(firstGuess: Double): Double = {  
  def iterate(guess: Double): Double = {  
    val next = f(guess)  
    if (isCloseEnough(guess, next)) next  
    else iterate(next)  
  }  
  
  iterate(firstGuess)  
}  
  
// Average dampening function to reduce oscillation  
def averageDamp(f: Double => Double): Double => Double = {  
  x => (x + f(x)) / 2  
}  
  
// Square root function using fixed points  
def sqrt(x: Double): Double = {  
  fixedPoint(averageDamp(y => x / y))(1.0)}  
  
sqrt(16)
```


<font color="#f79646">Here’s a more detailed yet simplified version of the notes:</font>

### Understanding Higher-Order Functions and Fixed Points:

1. **Fixed Point Concept**:  
   - A fixed point of a function \( f \) is a value \( x \) such that \( f(x) = x \).
   - Some functions can find fixed points by starting with an initial guess and applying the function repeatedly until the result stabilizes (doesn't change much between iterations).

2. **Iterative Process**:  
   - Start with an initial estimate.
   - Apply the function repeatedly, i.e., \( x, f(x), f(f(x)), \ldots \), until the value converges (i.e., the difference between successive values becomes very small).
   - A "close enough" condition ensures convergence when the difference between the current and next values is small compared to the current value.

3. **Square Root Calculation Using Fixed Points**:  
   - The square root of \( x \) is the value \( y \) such that \( y^2 = x \), or equivalently \( y = \frac{x}{y} \). Thus, the square root is a fixed point of the function \( f(y) = \frac{x}{y} \).
   - However, iterating this function can cause oscillation between two values (e.g., 1 and 2 when calculating the square root of 2), leading to non-convergence.

4. **Average Damping to Control Oscillations**:  
   - To avoid oscillation, apply average damping by averaging the previous value and the next value:  
     \( f(y) = \frac{y + \frac{x}{y}}{2} \).
   - This technique helps the iteration converge more rapidly and stably.

5. **Abstraction with Higher-Order Functions**:  
   - **Higher-order functions** allow functions to be passed as arguments or returned as results, enabling more flexible and reusable code.
   - The "average damp" function abstracts the damping process. It takes a function \( f \) and returns a new function that applies \( f \) and averages the result with the previous value.

6. **Applying Higher-Order Functions**:  
   - The square root function can now be expressed as a fixed point of the average-damped function \( f(y) = \frac{x}{y} \), making the code cleaner and more reusable.
   - By combining the fixed-point method and average damping, we get a general approach to solving many problems, including calculating square roots.

7. **Benefits of Abstraction and Reusability**:  
   - Abstraction allows programmers to write general-purpose code that can be reused for different problems.
   - While higher abstraction levels aren’t always best, it’s important to know how to abstract when needed for clarity and reusability.

In summary, higher-order functions and fixed points allow us to create flexible, reusable solutions. The square root problem illustrates how fixed points and average damping help achieve better convergence in numerical computations.


------

# Lecture-2-4-Scala-Syntax-Summary
###  Syntax

- Types can be:
    
    - Numeric type (`Int`, `Double`, `Byte`, `Short`, `Char`, `Long`, `Float`)
    - Boolean type (`true`, `false`)
    - `String` type
    - Function type (`Int => Int`, `(Int, Int) => Int`)
- Expressions can be:
    
    - An identifier like `x`, `isGoodEnough`
    - A literal like `0`, `1.0`, `"abc"`
    - A function application like `sqrt(x)`
    - An operator application like `-x`, `y + x`
    - A selection like `math.abs`
    - A conditional expression like `if (x > 0) x else -x`
    - A block like `{ val x = math.abs(y) ; x * 2 }`
    - An anonymous function like `x => x + 1`
- Definitions can be:
    
    - A function definition like `def sqrt(x: Int): Double = {}`
    - A value definition like `val y = sqrt(2)`
- Parameter can be:
    
    - Call by value parameter like `(x: Int)`
    - Call by name parameter like `(y: => Double)`

---------------------------


# Lecture-2-5-Functions-and-Data

Here’s a simple note explaining key points about the Scala code from the subtitle:

1. **Primitive Data Types vs Custom Data Types**: So far, we’ve used basic types like `Int` and `String`. Now, we’ll learn to create our own types using a **class**.

2. **Rational Numbers**: We’ll design a package to handle rational numbers (fractions). A rational number like `x/y` has a **numerator** (`x`) and a **denominator** (`y`).

3. **Defining a Class**: In Scala, we create a new data type by defining a class, like `class Rational(n: Int, d: Int)` where `n` is the numerator and `d` is the denominator.

4. **Creating Objects**: We can create an object (an instance of the class) using the class name like this: `val r = Rational(1, 2)` (which represents the fraction 1/2).

5. **Accessing Members**: We can access the numerator and denominator using `r.numer` and `r.denom`.

6. **Adding Functions**: Instead of managing numerators and denominators separately, we can write functions to add, subtract, multiply, and divide rational numbers. For example:
   ```scala
   def add(r: Rational) = 
      new Rational(this.numer * r.denom + r.numer * this.denom, this.denom * r.denom)
   ```

7. **String Representation**: We can define a method `toString` to display the rational number as a string, like "1/2". In Scala, we use **string interpolation** to achieve this:
   ```scala
   override def toString = s"$numer/$denom"
   ```

8. **Method Override**: When we change a built-in method like `toString`, we use `override` to indicate we are replacing the default behavior.

9. **Negation and Subtraction**: We can add methods like `neg` (to negate a rational number) and `sub` (to subtract one rational from another). The subtraction can use the negation method internally:
   ```scala
   def sub(r: Rational) = add(r.neg)
   ```

10. **Testing**: Finally, we test the code by performing operations like adding and multiplying rational numbers, and converting them to strings.

These notes outline how you can handle fractions using classes and methods in Scala, showing how to organize operations neatly within the data structure.

# Lecture-2-6-Data-Abstraction

1. **Data Abstraction Concept**:
   - The process of<font color="#f79646"> hiding implementation details</font> while exposing only essential features.
   
```scala
class Rational(x: Int, y: Int):  
  require(y > 0, s"denominator must be positive, was $x/$y")  
  def this(x: Int) = this(x, 1) // in case of integers pass denominator is 1 default.  
  
  private def gcd(a: Int, b: Int): Int =  
    if b == 0 then a else gcd(b, a % b)  
  
  def numer = x / gcd(x.abs, y)  
  def denom = y / gcd(x.abs, y)  
  
  def add(r: Rational) =  
    Rational(numer * r.denom + r.numer * denom, denom * r.denom)  
  
  def mul(r: Rational) =  
    Rational(numer * r.numer, denom * r.denom)  
  
  def neg = Rational(-numer, denom)  
  
  def sub(r: Rational) = add(r.neg)  
  
  def less(that: Rational): Boolean =  
    numer * that.denom < that.numer * denom  
  
  def max(that: Rational): Rational =  
    if this.less(that) then that else this  
  
  override def toString = s"$numer/$denom"  
end Rational // end for closing the Rational class  
  
val x = Rational(1, 3)  
val y = Rational(5, 7)  
val z = Rational(3, 2)  
  
x.add(y).mul(z)  
x.sub(y).sub(z)
```

### Explanation of the above Code:

This Scala code defines a class `Rational` that models rational numbers (fractions) with basic arithmetic operations such as addition, multiplication, negation, and subtraction. It also includes comparison operations like finding the maximum of two rational numbers. The key aspects of the code are as follows:

---

### 1. **Primary Constructor & Require Statement**
```scala
class Rational(x: Int, y: Int):
  require(y > 0, s"denominator must be positive, was $x/$y")
```
- **Primary Constructor**: This takes two integers, `x` (numerator) and `y` (denominator), to create a rational number `x/y`.
- **Require**: A built-in method to ensure the denominator (`y`) is positive. If `y <= 0`, the program throws an `IllegalArgumentException` with the message `"denominator must be positive"`, displaying the invalid input.

---

### 2. **Auxiliary Constructor**
```scala
def this(x: Int) = this(x, 1)
```
- **Auxiliary Constructor**: This provides a way to create a rational number with only a numerator (e.g., `Rational(5)` will be treated as `5/1`).
  
---

### 3. **Greatest Common Divisor (GCD) Method**
```scala
private def gcd(a: Int, b: Int): Int =
  if b == 0 then a else gcd(b, a % b)
```
- **GCD Function**: This recursive method calculates the greatest common divisor (GCD) of two numbers, `a` and `b`. It ensures that the rational number is simplified to its lowest terms.
  - If `b == 0`, the GCD is `a`.
  - Otherwise, the function recurses, calculating `gcd(b, a % b)` until `b == 0`.

---

### 4. **Numerator and Denominator**
```scala
def numer = x / gcd(x.abs, y)
def denom = y / gcd(x.abs, y)
```
- **Simplification**: The `numer` (numerator) and `denom` (denominator) methods return the simplified form of the rational number by dividing both `x` and `y` by their GCD. `x.abs` ensures that the GCD computation works even if `x` is negative.

---

### 5. **Addition**
```scala
def add(r: Rational) =
  Rational(numer * r.denom + r.numer * denom, denom * r.denom)
```
- **Add**: This method adds two rational numbers using the formula:
  - It computes the sum of two rational numbers `this` (current object) and `r` (another `Rational`), creating a new `Rational` instance for the result.

---

### 6. **Multiplication**
```scala
def mul(r: Rational) =
  Rational(numer * r.numer, denom * r.denom)
```
- **Mul**: This method multiplies two rational numbers using the formula:
  - It returns the product of the current `Rational` object and another `Rational`.

---

### 7. **Negation**
```scala
def neg = Rational(-numer, denom)
```
- **Neg**: This method returns the negative of the rational number by negating its numerator (i.e., flipping the sign of the fraction).

---

### 8. **Subtraction**
```scala
def sub(r: Rational) = add(r.neg)
```
- **Sub**: This method subtracts one rational number from another by negating the second rational number (`r.neg`) and adding it to the current one.
  \[
  \frac{a}{b} - \frac{c}{d} = \frac{a}{b} + \frac{-c}{d}
  \]

---

### 9. **Less Than Comparison**
```scala
def less(that: Rational): Boolean =
  numer * that.denom < that.numer * denom
```
- **Less**: This method compares two rational numbers. It checks if the current `Rational` is less than another `Rational` by cross-multiplying:
  \[
  \frac{a}{b} < \frac{c}{d} \quad \text{if} \quad a \cdot d < c \cdot b
  \]

---

### 10. **Maximum of Two Rational Numbers**
```scala
def max(that: Rational): Rational =
  if this.less(that) then that else this
```
- **Max**: This method returns the larger of two rational numbers by checking if the current number (`this`) is less than the other (`that`). If so, it returns `that`; otherwise, it returns `this`.

---

### 11. **String Representation**
```scala
override def toString = s"$numer/$denom"
```
- **toString**: This method provides a string representation of the rational number in the form `"numerator/denominator"`.

---

### 12. **End Marker**
```scala
end Rational
```
- **End Marker**: This indicates the end of the `Rational` class, helping with readability in large blocks of code.

---

### 13. **Examples of Usage**
```scala
val x = Rational(1, 3)
val y = Rational(5, 7)
val z = Rational(3, 2)

x.add(y).mul(z)
x.sub(y).sub(z)
```
- **Operations**:
  - `x.add(y).mul(z)`: Adds `x` and `y`, then multiplies the result by `z`.
  - `x.sub(y).sub(z)`: Subtracts `y` from `x`, then subtracts `z` from the result.

---

### Summary:
- The class `Rational` models rational numbers and includes methods for performing basic arithmetic and comparisons. 
- The constructor ensures that denominators are always positive, and the rational numbers are simplified using GCD.
- The class includes methods for addition, multiplication, negation, subtraction, and comparison (`less` and `max`).

Que: Extension methods
- [ ] can use `this`
- [ ] can override existing members
- [x] can define new members for a type
- [x] can define infix operators
- [ ] can access private of the class that they extend

