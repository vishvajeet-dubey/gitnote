package com.vdubey.a01_scala_class_pkg

/* Fields, which you define with either val or var, are variables that refer to objects. 
 * Methods, which you define with def, contain executable code. The fields hold the 
 * state, or data, of an object, whereas the methods use that data to do the computational work of the object
 * https://github.com/vishvajeet-dubey/gitnote/blob/main/a05-scala/scala-basic.md#01-02-Fields-and-Methods
 */

object A_01_02_fileds_methods extends App {

  class ChecksumAccumulator_01_02 { 
	var sum = 0 
	println("value of var sum = " + sum)
	} 
  // and you instantiated it twice with: 

val acc = new ChecksumAccumulator_01_02 
val csa = new ChecksumAccumulator_01_02

// var can be changed based on object.
acc.sum=4

println("new value of object acc " + acc.sum)

}

