
object Solution {
  def lengthOfLongestSubstring(s: String): Int = {
    val lastSeen = scala.collection.mutable.Map[Char, Int]()

    var left = 0
    var maxLength = 0

    for (right <- s.indices) {
      val ch = s(right)

      // Move the left pointer if the character was seen
      // inside the current window
      if (lastSeen.contains(ch) && lastSeen(ch) >= left) {
        left = lastSeen(ch) + 1
      }

      lastSeen(ch) = right

      maxLength = maxLength.max(right - left + 1)
    }

    maxLength
  }
}