package com.vdubey.a02_Control_Structure_and_Collection

class ifExpression(A: Int) {
	val evenOddval = A

			if (A%2==0) {
				println(s"${evenOddval} is a Even Number")
			} else {
				println(s"${evenOddval} is a Odd Number")
			}

	
	
	
	// lets create a method to find max number
	def max(a: Int, b: Int): Unit = {
			var max: Int = a

					if (b > a) {
						max = b
					}

	println(s"Maximum is $max")
	}

	
	
	// NASTED IF ELSE
	def nastedIfElse(A: Int) {
		val number = A
				if (number == 0) {
					println("Number is zero")
				} else if (number > 100) {
					println("Number is greater than 100")
				} else {
					println(s"Number is $number")
				}
	}
	
	
	// Idiomatic-Conditional-Initialization
	// it's idiomatic to use an if expression to initialize variables conditionally
	val centuryTest = if (evenOddval>=100) {s"${evenOddval} is more than or equal to century"} else{s"${evenOddval} is less than century"}
}

object a01_Conditions {
	def main(args: Array[String]): Unit = {

			val objOfIfExp = new ifExpression(11)
					objOfIfExp.max(11, 10)
					objOfIfExp.nastedIfElse(11)
					println(objOfIfExp.centuryTest)


	}
}