/*
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
 */

class Rational(x: Int, y: Int):
  def numer = x
  def denom = y

  def add(r: Rational) =
    Rational(numer * r.denom + r.numer * denom, denom * r.denom)

  def mul(r: Rational) =
    Rational(numer * r.numer, denom * r.denom)

  def neg = Rational(-numer, denom)

  def sub(r: Rational) = add(r.neg)

  override def toString = s"$numer/$denom"
end Rational

val x = Rational(1, 3)
val y = Rational(5, 7)
val z = Rational(3, 2)

x.add(y).mul(z)
x.sub(y).sub(z)

