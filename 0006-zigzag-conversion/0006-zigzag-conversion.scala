
object Solution {
  def convert(s: String, numRows: Int): String = {
    if (numRows == 1 || numRows >= s.length) {
      return s
    }

    val rows = Array.fill(numRows)(new StringBuilder)

    var currentRow = 0
    var direction = 1

    for (ch <- s) {
      rows(currentRow).append(ch)

      if (currentRow == 0) {
        direction = 1
      } else if (currentRow == numRows - 1) {
        direction = -1
      }

      currentRow += direction
    }

    rows.map(_.toString).mkString
  }
}