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
    public ListNode reverseBetween(ListNode head, int start, int end) {
        if (head == null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        for (int i = 0; i < start - 1; i++) {
            prev = prev.next;
        }
        ListNode curr = prev.next;
        ListNode nodeToMove;
        for (int i = 0; i < end - start; i++) {
            nodeToMove = curr.next;
            curr.next = curr.next.next;
            nodeToMove.next = prev.next;
            prev.next = nodeToMove;
        }
        return dummy.next;
    }
}