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
        if (head == null || head.next == null) return true;
        ListNode med = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            med = med.next;
        }

        ListNode prev = null;
        ListNode curr = med.next;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        med.next = prev;

        curr = head;
        med = med.next;

        while (curr != null && med != null) {
            if (curr.val != med.val) {
                return false;
            }
            curr = curr.next;
            med = med.next;
        }
        return true;
    }
}