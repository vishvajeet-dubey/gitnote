# Lecture-3-Intro
Dynamic binding in Scala (and in object-oriented programming in general) refers to the mechanism where the <font color="#f79646">method to be invoked is determined at runtime </font>rather than at compile time. This is closely related to **polymorphism** and **inheritance**.

In Scala, dynamic binding allows the most specific implementation of a method to be invoked, based on the actual type of the object, even if the reference to the object is of a more general type (such as a superclass or a trait). This is achieved using **virtual method dispatch**.

### Example:

Let's say we have a base class `Animal` and two subclasses `Dog` and `Cat`, each with their own `speak` method.

```scala
class Animal {
  def speak(): Unit = {
    println("The animal speaks")
  }
}

class Dog extends Animal {
  override def speak(): Unit = {
    println("The dog barks")
  }
}

class Cat extends Animal {
  override def speak(): Unit = {
    println("The cat meows")
  }
}

object Main extends App {
  val animal: Animal = new Dog()
  animal.speak()  // Output: "The dog barks"
}
```

### Explanation:
- Here, `animal` is of type `Animal`, but it holds an instance of `Dog`. When `animal.speak()` is called, Scala uses dynamic binding to determine that the `Dog`'s `speak` method should be invoked, rather than `Animal`'s method.
- Even though the type of the reference (`animal`) is `Animal`, the method executed is from the subclass `Dog` because the actual object is of type `Dog`.

### Key points:
- **Static binding** (compile-time binding) occurs when the method to be called is determined at compile time.
- **Dynamic binding** (runtime binding) occurs when the method to be called is determined at runtime, based on the actual object's type.
- In Scala, dynamic binding is used for instance methods (non-static) by default.

This feature is crucial for achieving polymorphism, where the behavior of methods can differ depending on the object's runtime type, even when accessed through a common interface or superclass.


# Lecture-3-1-Class-Hierarchies

#### 1. **Abstract Classes**
- **Abstract class**: A class that can have methods without implementations (called abstract members). Instances of an abstract class cannot be created directly.
- Example:

  ```scala
abstract class IntSet:  
  def incl(x: Int): IntSet  
  def contains(x: Int): Boolean  
end IntSet
  ```

#### 2. **Class Extensions**
- Classes can extend abstract classes to provide specific implementations.
- For example, sets of integers can be represented as binary trees with two implementations:
  - **Empty set**: Contains no elements.
  - **NonEmpty set**: Contains an integer and two sub-trees.

```scala
class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet :  
  def contains(x: Int): Boolean =  
    if (x < elem) left.contains(x)  
    else if (x > elem) right.contains(x)  
    else true  
  
  def incl(x: Int): IntSet =  
    if (x < elem) new NonEmpty(elem, left.incl(x), right)  
    else if (x > elem) new NonEmpty(elem, left, right.incl(x))  
    else this  
end NonEmpty  
  
class Empty extends IntSet :  
  def contains(x: Int): Boolean = false  
  def incl(x: Int): IntSet = new NonEmpty(x, Empty(), Empty())  
end Empty
```

#### 3. **Terminology**
- **Superclass**: A class like `IntSet` that is extended by other classes.
- **Subclass**: Classes like `Empty` and `NonEmpty` that extend a superclass.
- **Base Classes**: All the direct or indirect superclasses of a class.

#### 4. **Implementation and Overriding**
- Subclasses must implement abstract methods from the superclass.
- **Override**: Used to redefine existing non-abstract methods in a subclass.

  ```scala
  abstract class Base {
    def foo: Int = 1
  }
  
  class Sub extends Base {
    override def foo: Int = 2
  }
  ```

#### 5. **Singleton Objects**
- **Singleton object**: A class that has <font color="#f79646">only one instance</font>. It’s created using the `object` keyword.
  - Example: The `Empty` set is best expressed as a singleton since all empty sets are identical.

  ```scala
  object Empty extends IntSet {
    def contains(x: Int): Boolean = false
    def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  }
  ```

#### 6. **Companion Objects**
- A **companion object** shares the<font color="#f79646"> same name as a class</font> but provides methods related to the class.
- Example: `IntSet` companion object for a method that creates a set with one element.

  ```scala
  class IntSet ...
  object IntSet {
    def singleton(x: Int) = new NonEmpty(x, Empty, Empty)
  }
  ```

#### 7. **Programs in Scala**
- Scala programs can contain an object with a `main` method, similar to Java:

  ```scala
  object Hello {
    def main(args: Array[String]): Unit = println("Hello, world!")
  }
  ```

- You can also write standalone applications using `@main` annotation:

  ```scala
  @main def birthday(name: String, age: Int) = {
    println(s"Happy Birthday, $name! $age years old!")
  }
/*
> scala birthday Pater 11
> Happy Birthday, Pater! 11 years old!
*/
  ```

#### 8. **Dynamic Binding**
- **Dynamic method dispatch**: The method that gets called depends on the runtime type of the object, not the reference type.
  - Example:

    ```scala
    Empty.contains(1)  // Always false
    NonEmpty(7, Empty, Empty).contains(7)  // True
    ```

#### 9. **Exercise: Union of Two Sets**
- You can extend `IntSet` with a method to compute the union of two sets:

  ```scala
  abstract class IntSet {
    def union(other: IntSet): IntSet
  }
  ```

This overview provides a foundation on class hierarchies, abstract classes, and object-oriented principles in Scala based on the provided material.   

QUE: Abstract classes
- ✅ can have companion objects
- ✅ can extend other classes
- ✅ can be extended
- ❎ can be instantiated.

------------------



# Lecture-3-2-How-classes-are-organized
### **Class Organization in Scala**
1. **Packages**: 
   - Classes and objects are organized in packages.
   - Example: `package progfun.examples` places the class/object in the package `progfun.examples`
   - Access via fully qualified name: `progfun.examples.Hello`.

2. **Imports**:
   - Use classes/objects via fully qualified name or import statement.
   - Example: 
     ```scala
     import week3.Rational 
     val r = Rational(1, 2)
     ```
   - Forms of imports:
     - Named imports: `import week3.{Rational, Hello}`
     - Wildcard imports: it will import everything from package `import week3._`

3. **Automatic Imports**:
   - Automatically included in Scala programs:
     - All members of `scala`, `java.lang`, and `scala.Predef`.
   - Examples:
     - `Int` → `scala.Int`
     - `Object` → `java.lang.Object`
     - `assert` → `scala.Predef.assert`

4. **Traits**:
   - A trait is like an abstract class, but more powerful as it supports fields and concrete methods.
   - Example:
     ```scala
     trait Planar {
       def height: Int
       def width: Int
       def surface = height * width
     }
     ```
   - Classes can inherit from multiple traits but only one class.
   - Example: `class Square extends Shape, Planar, Movable`

5. **Scala’s Class Hierarchy**:
   - **Any**: Base type of all types, with methods like `==`, `!=`, `toString`.
   - **AnyRef**: Base type for reference types, alias for `java.lang.Object`.
   - **AnyVal**: Base type for primitive types.

6. **Nothing Type**:
   - Sits at the bottom of the hierarchy, subtype of all types.
   - Useful for:
     - Signaling abnormal termination.
     - Element type of empty collections.

7. **Exceptions**:
   - Exception handling similar to Java.
   - `throw Exc` type is `Nothing`.
   - The type of this expression is Nothing.
   - aborts evaluation with the exception Exc.

What is the type `if true then 1 else false`   
- ❎ Int
- ❎ Boolean
- ✅ AnyVal
- ❎ Object
- ❎ Any

------------------
