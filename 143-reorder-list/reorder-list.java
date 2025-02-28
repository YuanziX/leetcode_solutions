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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode middle = slow.next;
        slow.next = null;

        ListNode before = null, current = middle, after;
        while (current != null) {
            after = current.next;
            current.next = before;
            before = current;
            current = after;
        }

        ListNode l1 = head, l2 = before;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            tail.next = l1;
            l1 = l1.next;
            tail = tail.next;
            tail.next = l2;
            l2 = l2.next;
            tail = tail.next;
        }

        if (l1 == null) {
            tail.next = l2;
        } else {
            tail.next = l1;
        }
        
        head = dummy.next;
    }
}