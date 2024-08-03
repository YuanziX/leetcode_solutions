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
        int length = lengthOfList(head);
        int numGroups = length / k;

        ListNode prev = null;
        ListNode current = head;
        ListNode newHead = null;
        ListNode newTail = null;
        ListNode next = null;

        for (int i = 0; i < numGroups; i++) {
            ListNode firstNode = current;

            for (int j = 0; j < k; j++) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            if (newHead == null)
                newHead = prev;
            else
                newTail.next = prev;
            newTail = firstNode;
        }
        newTail.next = current;
        return newHead;
    }

    public int lengthOfList(ListNode head) {
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

}