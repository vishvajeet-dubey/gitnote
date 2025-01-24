/*
Data Abstraction:
  The previous example has shown that rational numbers aren't always represented in their simplest form

  One would expect the rational numbers to be simplified:
    > reduce them to their smallest numerator and denominator by dividing both with a divisor.

  We could implement this in each rational operation, but it would be easy to forget this division in an operation.
 */

// Rational with Data Abstraction:

//class Rational(x: Int, y: Int):
//  private def gcd(a: Int, b: Int): Int =
//    if b == 0 then a else gcd(b, a%b)
//
//  private val g = gcd(x, y)
//  def number = x / g
//  def denom = y / g

/*
gcd and g are private members; we can only access them form inside the Rational class.
In this example , we calculate gcd immediately, so that its value can be re-used in the calculations of numer and denom.
*/

// It is also possible to call gcd in the code of number and denom:



// This can be advantageous if it is expected that the functions numer and denom are called infrequently.
// The Client's View
// Clients observe exactly the same behavior in each case.

//This ability to choose different implementations of data without affecting the clients is called data abstractions.

// It is a cornerstone of software engineering.

// SELF REFERENCE
// On the inside of a class, the name this represents the object on which the current method is executed.

// Example:
// Add the functions less and max to the class Rational.

// Note that a simple name m, which refers to another number of the class,
// is an abbreviation of this.m. Thus, an equivalent way to formulate less is as follows.
/*
def less(taht: Rational): Rational =
  this.numer * that.denom < that.numer * this.denom
 */


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



