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
        if (head == null) return null;

        int len = len(head);
        k = k % len;
        if (len == k || k == 0 || head.next == null) return head;

        ListNode curr = head;
        ListNode originalHead = head;

        for (int i = 0; i < len - k - 1; i++) {
            curr = curr.next;
        }

        head = curr.next;
        curr.next = null;
        curr = head;

        while (curr.next != null) {
            curr = curr.next;
        }

        curr.next = originalHead;

        return head;
    }

    private int len(ListNode head) {
        ListNode curr = head;
        int l = 0;
        while (curr != null) {
            l++;
            curr = curr.next;
        }
        return l;
    }
}