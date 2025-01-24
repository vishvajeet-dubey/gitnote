/*
------------------------------------------------------------------------------------------------
DYNAMIC BINDING --------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------
1. Methods to be invoked determine at the runtime rather than compile time.

2. Static binding: methods to be called is determined at compile time. also called compile
   time binding.

3. Dynamic Binding: methods to be called is determined at run time. also called run time binding.
 */


// scala 3 style of writing the class
class Animal:
  def speak(): Unit =
    println("The animal speaks")
end Animal

// scala 2 style of writing the class
class Dog extends Animal{
  override def speak(): Unit = {
    println("The dog barks")
  }
}

// scala 3 style of writing the class and inheritance
class Cat extends Animal:
  override def speak(): Unit =
    println("The cat meow")
end Cat

// create a instance of Dog of Animal type
val animal: Animal = new Dog()
animal.speak() // The Dog barks -- will return

/*
Explanation:
> Here the val `animal` is the type of `Animal` user define class but its hold and instance
  of `Dog` class. When `animal.speak()` is called, Scala uses dynamic binding to determine
  that the `Dog`'s `speak` method should be invoked, rather than `Animal`'s method.
 */