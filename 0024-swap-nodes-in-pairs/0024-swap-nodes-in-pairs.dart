
/**
 * Definition for singly-linked list.
 * class ListNode {
 *   int val;
 *   ListNode? next;
 *   ListNode([this.val = 0, this.next]);
 * }
 */

class Solution {
  ListNode? swapPairs(ListNode? head) {
    final dummy = ListNode(0, head);
    ListNode? prev = dummy;

    while (prev?.next != null &&
        prev!.next!.next != null) {
      ListNode first = prev.next!;
      ListNode second = first.next!;

      // Swap the two nodes
      first.next = second.next;
      second.next = first;
      prev.next = second;

      // Move to the next pair
      prev = first;
    }

    return dummy.next;
  }
}