/* -------------------------------------------------------------------------------
   - Finding a fixed point of a function -----------------------------------------
   -------------------------------------------------------------------------------
   -- A number x ix called a fixed point of a function f if

   -- f(x) = x

   -- For some functions f we can locate the fixed points by starting
   -- with an initial estimate and then by applying f in a respective way.

   -- x, f(x), f(f(x)), f(f(f(x))), ...

   -- until the value does not vary anymore ( or the changes is sufficiently
   -- small).

   - BELOW CODE WRITE IN INTELLIJ WORKSHEET
 */


// Function to calculate if two values are close enough based on tolerance
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


//----------------------------------------------------------------------------------
// Define a simple type: an integer
val number: Int = 5

// Define a function type: (Int) => Int
def square(x: Int): Int = x * x

// Define a function that takes two parameters (Int, Int) => Int
def sum(x: Int, y: Int): Int = x + y

// Conditional expression using if-else
def absoluteValue(x: Int): Int = if (x < 0) -x else x

// Function with higher-order function as a parameter (Int => Int)
def applyFunction(f: Int => Int, value: Int): Int = f(value)

// Example of blocks (val definition followed by an expression)
val result: Int = {
  val x = 2
  x * x
}

// Using the defined functions
val squareOfFive = square(5)   // Calls square function
val sumOfThreeAndFour = sum(3, 4)   // Calls sum function
val absOfNegativeSeven = absoluteValue(-7)  // Calls absoluteValue function
val applySquareToFour = applyFunction(square, 4)  // Calls applyFunction

// Printing the results
println(s"Square of 5: $squareOfFive")
println(s"Sum of 3 and 4: $sumOfThreeAndFour")
println(s"Absolute value of -7: $absOfNegativeSeven")
println(s"Applying square function to 4: $applySquareToFour")
