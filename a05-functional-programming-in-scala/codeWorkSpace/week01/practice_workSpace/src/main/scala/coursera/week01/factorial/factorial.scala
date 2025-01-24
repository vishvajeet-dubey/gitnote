package coursera.week01.factorial

import scala.jdk.Accumulator

object factorial extends App {
  // factorial without tail recursion
  def fact(x: Int): Double = if (x==0) 1 else x * fact(x-1)

  // factorial with tail recursion
  @scala.annotation.tailrec
  def factWithTailRec(n: Int, accumulator: Int): Double = if (n==0) accumulator else factWithTailRec(n-1, n * accumulator)

  val num = 5
  println(s"factorial of $num without tailRec = ${fact(num)}")
  println(s"factorial of $num with tailRec = ${factWithTailRec(num,1)}")



//  playingGround
//  private val aList = 1 to 200
//  aList.map(a => if (fact(a)!=Double.PositiveInfinity) a else null).foreach(println)

  /* NOTE ===============================
   * Tail Recursion: If a function calls itself as it's last action, the function's stack frame can be reuse.
   * Accumulator: it is a argument that store the previous rec function result
   */
}

