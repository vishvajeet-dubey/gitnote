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



// FUNCTION RETURNING FUNCTIONS
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



// multiple parameter list
// the definition of functions that return functions is so useful in functional programming
// that there is a special syntax for it in Scala.

// for example, the following definition of sum is equivalent to the
// one with the nested sum function. but shorter

def sum(f: Int => Int)(a: Int, b: Int) : Int =
  if (a>b) 0 else f(a) + sum(f)(a + 1, b)

sum(x=> x*x*x) (2, 5)
// ---------------------------------------





// -----------------------------------------------------------------
// Que 1. Write a function that calculates the product of the value
// of a function for the points on a given interval

def product(f: Int => Int)(a: Int, b: Int): Int =
  if (a>b) 1 else f(a) * product(f)(a + 1, b)

product(x => x*x)(2, 5)
// ------------------------------------------------------------------





// -----------------------------------------------------------------
// Que 2. Write a factorial function in terms of product

def factorial(n: Int) = product(x => x)(1, n)
factorial(5)
// -----------------------------------------------------------------





// -----------------------------------------------------------------
// que 3. Combine the product and sum function

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int ={
  def recur(a: Int): Int =
    if (a>b) zero
    else combine(f(a), recur(a + 1))
  recur(a)
}

def sum(f: Int => Int)      = mapReduce(f, (x, y) => x + y, 0)(_, _)
def product(f: Int => Int)  = mapReduce(f, (x, y) => x * y, 1)(_, _)

sum(x => x*x)(1, 5)
product(x=> x)(1, 6)







// -----------------------------------------------------------------
// CURRYING
def Add(a: Int)(b: Int): Int = {a + b}
Add(2)(5)

// currying using Lambda function
def lemAdd(a: Int)=(b: Int) => a +  b
lemAdd(2)(5)
// -----------------------------------------------------------------






// -----------------------------------------------------------------
// Curring Problems-------------------------------------------------
// -----------------------------------------------------------------
def f(a: String)(b: Int)(c: Boolean): String = {
  "(" + a + ", " + b + ", " + c + ")"
}// First partial application: a is bound
val partialApplication1 = f("Scala") _ //(_) the function doesn't apply fully
val partialApplication2 = partialApplication1(42)(true)
// -----------------------------------------------------------------
