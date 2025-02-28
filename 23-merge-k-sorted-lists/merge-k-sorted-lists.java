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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode l: lists) {
            while (l != null) {
                pq.offer(l.val);
                l = l.next;
            }
        }

        ListNode head = null;
        ListNode curr = null;
        
        while (!pq.isEmpty()) {
            if (head == null) {
                head = new ListNode(pq.poll());
                curr = head;
                continue;
            } else {
                curr.next = new ListNode(pq.poll());
                curr = curr.next;
            }
        }

        return head;
    }
}