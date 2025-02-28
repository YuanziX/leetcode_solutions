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
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return Double.compare(l1.val, l2.val);
            }
        } );

        for (ListNode l: lists) {
            while (l != null) {
                pq.offer(l);
                l = l.next;
            }
        }

        ListNode head = null;
        ListNode curr = null;

        if (!pq.isEmpty()) {
            head = pq.poll();
            curr = head;
        }

        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
            curr.next = null;
        }

        return head;
    }
}