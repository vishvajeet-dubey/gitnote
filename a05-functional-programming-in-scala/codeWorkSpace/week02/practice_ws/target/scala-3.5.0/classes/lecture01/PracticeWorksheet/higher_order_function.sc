/* Higher order function
 * Functional languages treat functions as first-class values.
 * This means that, like any other value, a function can be passed as a parameter and returned as a result.
 * This provides a flexible way to compose programs.
 * Functions that take other functions as parameters or that return functions as results are called higher order function
 */

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
// -----------------------------------------

val name:string = "rajan"


// ANONYMOUS FUNCTION
// Using anonymous functions, we can write the sums in shorter way:
// In this way no need to explicitly defines the id, cube and fact functions.
def sumIntsUsingAF(a: Int, b: Int): Int           = sum(x => x, a, b)
def sumCubesUsingAF(a: Int, b: Int): Int          = sum(x => x*x*x, a, b)


// calling above function
sumIntsUsingAF(2, 5)
sumCubesUsingAF(2, 5)







// EXERCISE
// Write a tail recursive version of sum function which takes a function,
// perform operation on function and summation of integer between a and b
def SumTailRec(f: Int => Int, a: Int, b: Int) : Int = {
  def loop(a: Int, acc: Int): Int =
    if (a > b) acc
    else loop(a+1, acc + f(a))
  loop(a, 0)
}

// here, `x => x` and `x => x*x*x` is anonymous function
// which returns x itself and cubes of x respectively.
def sumIntsUsingAFWithTailRec(a: Int, b: Int): Int     = SumTailRec(x => x, a, b)
def sumCubesUsingAFWithTailRec(a: Int, b: Int): Int    = SumTailRec(x => x*x*x, a, b)

// calling above function:
sumIntsUsingAFWithTailRec(2,5)
sumCubesUsingAFWithTailRec(2, 5)
