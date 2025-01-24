package com.vdubey.a01_scala_class_pkg.A_01_05_scala_app_pkg
import scala.collection.mutable.Map

/*
 * companion = class + object with same name
 * for more check out the below links
 * https://github.com/vishvajeet-dubey/gitnote/blob/main/a05-scala/scala-basic.md#01-04-Singleton-Objects
 * https://github.com/vishvajeet-dubey/gitnote/blob/main/a05-scala/scala-basic.md#01-05-Scala-Application
 * 
 */

class ChecksumAccumulator { // companion class
	// In file ChecksumAccumulator.scala
	private var sum = 0 // will be shared in companion(class + object)
			def add(b: Byte) { sum += b } 
	    // add is method taking byte as b and not returning anything -- it is adding b in sum and reassigning the var sum
	
	def checksum(): Int = ~(sum & 0xFF) + 1
	// checksum is a method taking nothing and returning Int -- and operation of var `sum` and hex value of 255 then not operation
}


// In file ChecksumAccumulator.scala
object ChecksumAccumulator { // Companion object 
  
	private val cache = Map[String, Int]()
	// The calculate method takes a string s and returns its checksum:
			def calculate(s: String): Int = 
			if (cache.contains(s))
				cache(s)
				else {
					val acc = new ChecksumAccumulator
							for (c <- s)
								acc.add(c.toByte)
								val cs = acc.checksum()
								cache += (s -> cs)
								cs
				}
	
/*
 * EXPLANATION:
 * It first checks if the checksum for the string s is already in the cache.
 * If it is, it returns the cached checksum.
 * If it is not, it creates a new ChecksumAccumulator instance (acc).
 * It then iterates over each character in the string, converts it to a byte, and adds it to the accumulator.
 * After processing all characters, it calculates the checksum (cs).
 * It updates the cache with the new checksum (cache += (s -> cs)).
 * Finally, it returns the newly calculated checksum (cs).
 * 
 * 
 * ! Notes:
 * Map Mutation: The code uses Map += to add new entries, but this won't work directly 
 * since Map is immutable by default. You would need a mutable map or reassign the new 
 * map back to cache. This can be fixed by using a mutable map:
 */
}