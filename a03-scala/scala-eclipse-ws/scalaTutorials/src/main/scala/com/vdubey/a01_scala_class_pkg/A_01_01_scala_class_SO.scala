package com.vdubey.a01_scala_class_pkg

/* Author: Vishvajeet Dubey 
 * Check out the below link for more
 * https://github.com/vishvajeet-dubey/gitnote/blob/main/a05-scala/scala-basic.md#01-01-Classes
 */

object A_01_01_scala_class_SO extends App {

  class ChecksumAccumulator { 
	var sum = 0 
	println("value of var sum = " + sum)
	} 
  // and you instantiated it twice with: 

val acc = new ChecksumAccumulator 
val csa = new ChecksumAccumulator

// var can be changed based on object.
acc.sum=4

println("new value of object acc " + acc.sum)

}

