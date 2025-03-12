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
        if (head.next == null) return;
        
        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode mid = slow.next;
        slow.next = null;

        ListNode prev = null, next;

        while (mid != null) {
            next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }

        mid = prev;

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (head != null && mid != null) {
            tail.next = head;
            tail = tail.next;
            head = head.next;
            tail.next = mid;
            tail = tail.next;
            mid = mid.next;
        }

        head = dummy.next;
    }
}