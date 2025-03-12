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
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) return head;
        int len = len(head);
        k = k % len;
        if (k == 0) return head;


        ListNode curr = head;
        for (int i = 0; i < len - k - 1; i++) {
            curr = curr.next;
        }

        ListNode split = curr.next;
        ListNode res = split;
        curr.next = null;

        while (split.next != null) {
            split = split.next;
        }

        split.next = head;

        return res;
    }

    private int len(ListNode head) {
        ListNode c = head;
        int l = 0;
        while (c != null) {
            c = c.next;
            l++;
        }

        return l;
    }
}