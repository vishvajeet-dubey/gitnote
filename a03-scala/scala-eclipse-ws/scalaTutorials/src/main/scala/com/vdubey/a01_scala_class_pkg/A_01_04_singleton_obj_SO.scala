package com.vdubey.a01_scala_class_pkg
import scala.collection.mutable.Map

// Scala has no static methods or fields. Instead, you use the object construct.
// An Object defines a single instance of a class with the features that you want.

/*
 * SINGLETON OBJECT:
 * >> use keyword object instead of class defining the singleton object.
 * >> its create the a instance as soon as if defines.
 * >> it cannot takes parameters, where as classes takes.
 * 
 * COMPANION CLASS AND OBJECT:
 * >> when the singleton object shares the same name with a class, it is called as class's COMPANION OBJECT.
 * >> and the class is called COMPANION CLASS.
 * >> you must define the class and its companion object in the same source file. 
 * >> it can share the private fields and methods
 * 
 */

object A_01_04_singleton_obj_SO { // companion object // class name = object name 
	class Person(firstName: String, lastName: String){
		// field and methods
	}



	// singleton = one instance of a type is present.
	object ClusterSingleton {
		def MAX_NODES = 28
				def getNumberOfNodes(): Int = { 42 }
	}

	val maxNodes = ClusterSingleton.MAX_NODES
			println("Maximum number of node " + maxNodes)



			// same name of class + object in same file = companions
			class Kid(name: String, age: Int) {
		def greet(): String = s"Hello, my name is $name and I'm $age years old. Do I linke vegetables? ${Kid.LIKES_VEGETABLES}"
	}

	object Kid { // companion object of the class
		private val LIKES_VEGETABLES: Boolean = false
				// preconception
	}


	//  val kidsLikeVegetables = Kid.LIKES_VEGETABLES 
	// can not accessible as using private fields from outside of companions(class + object with same name)

	def main(args: Array[String]) : Unit = {
			val KidDewansh = new Kid("Dewansh", 6)
					println(KidDewansh.greet())
	}
}


