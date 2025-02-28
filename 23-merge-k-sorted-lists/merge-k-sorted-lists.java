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
    public ListNode sortTwoList(ListNode l, ListNode r) {
        if (l == null) return r;
        if (r == null) return l;

        if (l.val < r.val) {
            l.next = sortTwoList(l.next, r);
            return l;
        } else {
            r.next = sortTwoList(l, r.next);
            return r;
        }
    }

    public ListNode divideLists(ListNode[] lists, int l, int r) {
        if (l == r) return lists[r];

        int mid = l + (r - l) / 2;
        ListNode l1 = divideLists(lists, l, mid);
        ListNode l2 = divideLists(lists, mid + 1, r);

        return sortTwoList(l1, l2);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        return divideLists(lists, 0, lists.length - 1);
    }
}