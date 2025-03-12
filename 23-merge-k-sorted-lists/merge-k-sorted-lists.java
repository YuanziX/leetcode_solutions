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
    private ListNode join2List(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    private ListNode divideAndMerge(ListNode[] lists, int l, int r) {
        if (l == r) return lists[r];

        int mid = (l + r) / 2;

        ListNode l1 = divideAndMerge(lists, l, mid);
        ListNode l2 = divideAndMerge(lists, mid + 1, r);

        return join2List(l1, l2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        
        return divideAndMerge(lists, 0, lists.length - 1);
    }
}