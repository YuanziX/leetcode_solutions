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
    public ListNode reverseList(ListNode head) {
	    ListNode prev = null;
        ListNode after;
        while (head != null) {
            after = head;
            head = head.next;
            after.next = prev;
            prev = after;
        }
        return prev;
    }
}