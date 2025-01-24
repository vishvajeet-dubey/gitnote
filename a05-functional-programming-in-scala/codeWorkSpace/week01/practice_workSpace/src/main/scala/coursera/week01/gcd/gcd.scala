package coursera.week01.gcd

object gcd extends App {
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else{
//      println(s"a is $a and b is $b")
      gcd(b, a % b)
    }
  }

  println(s"GCD of Given Number is ${gcd(12, 20)}")
}
