//def abs(x:Double) = if (x < 0) -x else x
//def isGoodEnough(guess: Double, x: Double) = abs(guess * guess - x) < 0.001
//def improve(guess: Double, x: Double) =(guess + x / guess) / 2
//def sqrtIter(guess: Double, x: Double): Double =
//  if (isGoodEnough(guess, x)) guess
//  else sqrtIter(improve(guess, x), x)
//def sqrt(x: Double) = sqrtIter(1.0, x)
//
//
//import math.BigDecimal.RoundingMode
//BigDecimal(sqrt(2)).setScale(2, RoundingMode.HALF_UP)





//def gcd(a: Int, b: Int): Int =
//  if (b == 0) a else gcd(b, a % b)
//
//gcd(12, 16)




//def fact(x: Int): Double = if (x==0) 1 else x * fact(x-1)
//fact(170)