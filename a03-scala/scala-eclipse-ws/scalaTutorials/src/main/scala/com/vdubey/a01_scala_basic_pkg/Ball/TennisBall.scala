package com.vdubey.a01_scala_basic_pkg.Ball

import java.io._
import scala.math._


// defining the class
class Ball(diameter: Double) {
  var d: Double = diameter
  var c: Double = 0
  
  // defining the method which will calculate the circumference
  def calcCircumference(){
    c = Pi * d
    println(s"Circumference of ball: ${c} unit")
  }
}

object TennisBall {
  def main(args: Array[String]) {
    val BasketBall = new Ball(10)
    BasketBall.calcCircumference()
    
  }
}