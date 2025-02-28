/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int l = len(head);
        if (l < k) {
            return head;
        }

        ListNode current = head;

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        for (int i = l; i >= k; i -= k) {
            ListNode firstNode = current;
            ListNode before = null, after;

            for (int j = 0; j < k; j++) {
                after = current.next;
                current.next = before;
                before = current;
                current = after;
            }

            tail.next = before;
            tail = firstNode;
        }

        tail.next = current;

        return dummy.next;
    }

    private int len(ListNode head) {
        int l = 0;

        ListNode curr = head;
        while (curr != null) {
            l++;
            curr = curr.next;
        }

        return l;
    }
}