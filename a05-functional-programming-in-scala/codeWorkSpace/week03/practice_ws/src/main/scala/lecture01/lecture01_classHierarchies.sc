abstract class IntSet:
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
end IntSet



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

class Empty() extends IntSet :
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty(), Empty())
end Empty


val Empty: IntSet = new Empty()
val nonEmpty: IntSet = new NonEmpty(1, Empty, Empty)
Empty.contains(1) // Always false
//NonEmpty(7, Empty, Empty).contains(7) // True
nonEmpty.contains(1)


val set: IntSet = new Empty() // Start with an empty set

val setWithElements = set.incl(3).incl(5).incl(1).incl(2) // Add multiple integers

// Check if elements are in the set
println(setWithElements.contains(3)) // Output: true
println(setWithElements.contains(2)) // Output: false
println(setWithElements.contains(1)) // Output: true

