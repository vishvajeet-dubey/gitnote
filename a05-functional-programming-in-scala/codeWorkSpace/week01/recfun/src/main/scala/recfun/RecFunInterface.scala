package recfun

/**
 * The interface used by the grading infrastructure. Do not change signatures
 * or your submission will fail with a NoSuchMethodError.
 */
trait RecFunInterface {
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1 // Base case: edges of the triangle
    else pascal(c - 1, r - 1) + pascal(c, r - 1) // Recursive case: sum of the two numbers above
  }

  def balance(chars: List[Char]): Boolean = {
    def balanceHelper(chars: List[Char], openCount: Int): Boolean = {
      if (chars.isEmpty) openCount == 0
      else {
        val head = chars.head
        val newCount =
          if (head == '(') openCount + 1
          else if (head == ')') openCount - 1
          else openCount

        if (newCount < 0) false // More closing than opening
        else balanceHelper(chars.tail, newCount)
      }
    }

    balanceHelper(chars, 0)
  }


  //  def countChange(money: Int, coins: List[Int]): Int
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1  // Base case: one way to give change for 0 money (using no coins)
    else if (money < 0 || coins.isEmpty) 0  // No way to give change if money is negative or no coins are left
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
    // Recursive case:
    // - countChange(money - coins.head, coins): Use the first coin and reduce the amount of money.
    // - countChange(money, coins.tail): Skip the first coin and consider the rest of the coins.
  }

}