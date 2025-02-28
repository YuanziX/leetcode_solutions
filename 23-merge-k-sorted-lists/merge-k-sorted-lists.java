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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode merged = null;
        for (ListNode l: lists) {
            ListNode dummy = new ListNode(-1);
            ListNode tail = dummy;
            ListNode head1 = merged;
            ListNode head2 = l;

            while (head1 != null && head2 != null) {
                if (head1.val < head2.val) {
                    tail.next = head1;
                    head1 = head1.next;
                } else {
                    tail.next = head2;
                    head2 = head2.next;
                }
                tail = tail.next;
            }

            if (head1 == null) {
                tail.next = head2;
            } else {
                tail.next = head1;
            }
            
            merged = dummy.next;
        }

        return merged;
    }
}