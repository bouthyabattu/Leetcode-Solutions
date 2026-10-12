
class Solution {
  ListNode? reverseKGroup(ListNode? head, int k) {
    final dummy = ListNode(0, head);
    ListNode groupPrev = dummy;

    while (true) {
      ListNode? kth = groupPrev;

      for (int i = 0; i < k; i++) {
        kth = kth?.next;

        if (kth == null) {
          return dummy.next;
        }
      }

      ListNode? groupNext = kth!.next;

      ListNode? prev = groupNext;
      ListNode? curr = groupPrev.next;

      while (curr != groupNext) {
        ListNode? nextNode = curr!.next;
        curr.next = prev;
        prev = curr;
        curr = nextNode;
      }

      ListNode? oldGroupHead = groupPrev.next;
      groupPrev.next = kth;
      groupPrev = oldGroupHead!;
    }
  }
}