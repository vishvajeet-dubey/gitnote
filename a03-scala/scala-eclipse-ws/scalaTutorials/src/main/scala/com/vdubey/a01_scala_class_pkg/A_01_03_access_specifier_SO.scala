package com.vdubey.a01_scala_class_pkg

/*
 * In Scala, access specifiers (or access modifiers) control the visibility of-
 * members (fields, methods) of classes and objects. Scala has several access specifiers:
 * 1. Public: Default
 * 2. Private: private
 * 3. Protected: protected
 * 
 * ! IMPORTANT
 * Public field (default) -- No need to specify -- Accessible from anywhere
 * Method can access private and protected fields within the class
 * 
 */

class ChecksumAccumulator {
  // Public field (default)
  val publicField = "I am public"

  // Private field
  private val privateField = "I am private"

  // Protected field
  protected val protectedField = "I am protected"

  // Method to access private and protected fields within the class
  def printFields(): Unit = {
    println(publicField)
    println(privateField)
    println(protectedField)
  }
}

// Subclass to demonstrate protected field access
class SubChecksumAccumulator extends ChecksumAccumulator {
  def accessProtectedField(): Unit = {
    println(protectedField) // Accessible because it is protected
  }
}

object A_01_03_access_specifier_SO extends App {
  val acc = new ChecksumAccumulator

  // Accessing the public field
  println(acc.publicField) // Accessible

  // Accessing the private field (will cause a compilation error)
  // println(acc.privateField) // Not accessible

  // Accessing the protected field (will cause a compilation error)
  // println(acc.protectedField) // Not accessible

  acc.printFields() // Accessing all fields within the class

  val subAcc = new SubChecksumAccumulator
  subAcc.accessProtectedField() // Accessing protected field from subclass
}