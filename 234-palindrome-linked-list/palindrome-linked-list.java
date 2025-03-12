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
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head.next.next;

        // reach node before middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // assign middle node to var
        ListNode mid = slow.next;
        slow.next = null;

        // reverse list
        ListNode prev = null, after;
        while (mid != null) {
            after = mid.next;
            mid.next = prev;
            prev = mid;
            mid = after;
        }

        // assign reversed middle part list
        mid = prev;

        while (mid != null && head != null) {
            if (mid.val != head.val) {
                return false;
            }
            mid = mid.next;
            head = head.next;
        }

        return true;
    }
}