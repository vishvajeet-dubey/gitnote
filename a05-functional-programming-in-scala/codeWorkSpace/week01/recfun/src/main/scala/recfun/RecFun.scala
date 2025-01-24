package recfun

object RecFun extends RecFunInterface {

  def main(args: Array[String]): Unit = {
    println("Pascal's Triangle")
    for (row <- 0 to 4) {
      for (col <- 0 to row) {
        print(s"${pascal(col, row)} ")
      }
      println()
    }
    println(balance(List('(', 'i', 'f', ' ', '(', 't', 'r', 'u', 'e', ')', ')')))
    println(countChange(4, List(1, 2)))
  }
}