
object Solution {
  def generateParenthesis(n: Int): List[String] = {
    val result = scala.collection.mutable.ListBuffer[String]()

    def backtrack(current: String, open: Int, close: Int): Unit = {
      if (current.length == 2 * n) {
        result += current
        return
      }

      // Add '(' if fewer than n opening parentheses are used
      if (open < n) {
        backtrack(current + "(", open + 1, close)
      }

      // Add ')' only if it won't make the string invalid
      if (close < open) {
        backtrack(current + ")", open, close + 1)
      }
    }

    backtrack("", 0, 0)
    result.toList
  }
}