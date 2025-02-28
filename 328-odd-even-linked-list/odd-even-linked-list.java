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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode oddTail = odd;
        ListNode evenTail = even;

        int ind = 1;

        while (head != null) {
            if (ind % 2 == 1) {
                oddTail.next = head;
                oddTail = oddTail.next;
            } else {
                evenTail.next = head;
                evenTail = evenTail.next;
            }
            ind++;
            head = head.next;
        }

        oddTail.next = even.next;
        evenTail.next = null;
        return odd.next;
    }
}