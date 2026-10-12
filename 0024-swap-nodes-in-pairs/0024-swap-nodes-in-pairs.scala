
/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   def x: Int = _x
 * }
 */

object Solution {
  def swapPairs(head: ListNode): ListNode = {
    val dummy = new ListNode(0)
    dummy.next = head

    var prev = dummy

    while (prev.next != null && prev.next.next != null) {
      val first = prev.next
      val second = first.next

      // Swap the two nodes
      first.next = second.next
      second.next = first
      prev.next = second

      // Move to the next pair
      prev = first
    }

    dummy.next
  }
}