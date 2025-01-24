/*
 * ANONYMOUS FUNCTION:
 * - A function doesn't have a name.
 * - According to Wikipedia - "a function that is not bound to an identifier"
 * - It is also called the lambda function
 */

val ints = List(1,2,3)

val doubleList = ints.map(_ * 2)

// above is the shorthand way for writing the anonymous function.
// we can write like this also.
// LONGER FORM
val doubleList01 = ints.map((i: Int) => i*2) // or,
val doubleList02 = ints.map((i) => i*2) // or,
val doubleList03 = ints.map(i => i*2)


// SHORTENING THE ANONYMOUS FUNCTION
// the anonymous function the above expression is below
// (i: Int) => i * 2
// This long form can be shortened, as will be shown in the following steps.
// First, here’s that longest and most explicit form again:
val doubleLists = ints.map((i: Int) => i * 2)

// Because scala compiler infer the data so `Int` is not required
val doubleLists = ints.map((i) => i * 2)

// Because only one argument the parenthesis around `i` is not needed
val doubleLists = ints.map(i => i * 2)

// Because Scala lets you use the `_` symbol instead of a variable name when the
// parameter appears only once in your function, the code can be simplified even more:
val doubleLists = ints.map(_ * 2)


/* Going even shorter
 * In other examples, you can simplify your anonymous functions further.
 * For instance, beginning with the most explicit form, you can print each
 * element in `ints` using this anonymous function with the List class foreach method:
 */
ints.foreach((i: Int) => println(i))

// as before `Int` declaration in not required we can skipp
ints.foreach(i => println(i))

// Because i is used only once in the body of the function,
// the expression can be further simplified with the _ symbol:
ints.foreach(println(_))

// Finally, if an anonymous function consists of one method call that takes
// a single argument, you don’t need to explicitly name and specify the argument,
// so you can finally **write only the name of the method** (here, println):
ints.foreach(println)