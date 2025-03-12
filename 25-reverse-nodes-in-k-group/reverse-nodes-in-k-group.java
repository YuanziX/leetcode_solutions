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
        if (head.next == null) return head;

        int len = len(head);
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode curr = head;

        for (int i = 0; i < len / k; i ++) {
            ListNode prev = null, after;       
            for (int j = 0; j < k; j++) {
                after = curr.next;
                curr.next = prev;
                prev = curr;
                curr = after;
            }

            tail.next = prev;
            while (tail.next != null) {
                tail = tail.next;
            }
        }
        tail.next = curr;

        return dummy.next;
    }

    private int len(ListNode head) {
        ListNode c = head;
        int l = 0;

        while (c != null) {
            l++;
            c = c.next;
        }

        return l;
    }
}