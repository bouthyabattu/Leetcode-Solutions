
/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   def x: Int = _x
 * }
 */

object Solution {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    val dummy = new ListNode(0)
    var current = dummy
    var p = l1
    var q = l2
    var carry = 0

    while (p != null || q != null || carry > 0) {
      val x = if (p != null) p.x else 0
      val y = if (q != null) q.x else 0

      val sum = x + y + carry
      carry = sum / 10

      current.next = new ListNode(sum % 10)
      current = current.next

      if (p != null) p = p.next
      if (q != null) q = q.next
    }

    dummy.next
  }
}