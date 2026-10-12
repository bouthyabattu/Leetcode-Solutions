
object Solution {
  def myAtoi(s: String): Int = {
    val INT_MAX = Int.MaxValue
    val INT_MIN = Int.MinValue

    var i = 0
    val n = s.length
    var sign = 1
    var result = 0

    // 1. Skip leading spaces
    while (i < n && s(i) == ' ') {
      i += 1
    }

    // 2. Determine the sign
    if (i < n && (s(i) == '+' || s(i) == '-')) {
      if (s(i) == '-') sign = -1
      i += 1
    }

    // 3. Convert digits and check overflow
    while (i < n && s(i) >= '0' && s(i) <= '9') {
      val digit = s(i) - '0'

      if (result > INT_MAX / 10 ||
          (result == INT_MAX / 10 && digit > 7)) {
        return if (sign == 1) INT_MAX else INT_MIN
      }

      result = result * 10 + digit
      i += 1
    }

    result * sign
  }
}