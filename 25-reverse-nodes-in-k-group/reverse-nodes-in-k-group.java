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
        int l = len(head);
        if (l < k) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode current = head;

        // iterate for n k-groups
        for (int i = 0; i < l / k; i++) {
            // keep pointer on first node, this will be reversed so it'll be at the end
            // 1 -> 2
            // ^
            ListNode first = current;
            ListNode before = null, after;

            // revert jth k-group
            for (int j = 0; j < k; j++) {
                after = current.next;
                current.next = before;
                before = current;
                current = after;
            }

            // attach reversed k-group to dummy node
            tail.next = before;
            // move tail to end of the reversed k group which is the actual new tail
            // reversed = 2 -> 1
            //                 ^ 'first' pointer
            tail = first;
        }

        // attach remaining nodes
        // left over from non k-group (li < k)
        tail.next = current;

        return dummy.next;
    }

    private int len(ListNode head) {
        int l = 0;

        ListNode curr = head;
        while (curr != null) {
            l++;
            curr = curr.next;
        }

        return l;
    }
}