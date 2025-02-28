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
                ListNode temp = l;
                l = l.next;
                temp.next = null;
                pq.offer(temp);
            }
        }

        ListNode head = null;
        ListNode curr = null;
        
        while (!pq.isEmpty()) {
            if (head == null) {
                head = pq.poll();
                curr = head;
                continue;
            } else {
                curr.next = pq.poll();
                curr = curr.next;
            }
        }

        return head;
    }
}