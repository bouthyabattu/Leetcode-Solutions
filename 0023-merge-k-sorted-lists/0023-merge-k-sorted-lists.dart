
/**
 * Definition for singly-linked list.
 * class ListNode {
 *   int val;
 *   ListNode? next;
 *   ListNode([this.val = 0, this.next]);
 * }
 */

class Solution {
  ListNode? mergeKLists(List<ListNode?> lists) {
    // Collect all node values
    final List<int> values = [];

    for (final head in lists) {
      ListNode? current = head;

      while (current != null) {
        values.add(current.val);
        current = current.next;
      }
    }

    // Sort all values
    values.sort();

    // Build the merged linked list
    final dummy = ListNode(0);
    ListNode tail = dummy;

    for (final value in values) {
      tail.next = ListNode(value);
      tail = tail.next!;
    }

    return dummy.next;
  }
}