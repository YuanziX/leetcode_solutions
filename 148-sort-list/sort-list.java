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
    ListNode merge2List(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (n1 != null && n2 != null) {
            if (n1.val < n2.val) {
                tail.next = n1;
                n1 = n1.next;
            } else {
                tail.next = n2;
                n2 = n2.next;
            }
            tail = tail.next;
        }

        while (n1 != null) {
            tail.next = n1;
            n1 = n1.next;
            tail = tail.next;
        }

        while (n2 != null) {
            tail.next = n2;
            n2 = n2.next;
            tail = tail.next;
        }

        return dummy.next;
    }

    ListNode divideList(ListNode list) {
        if (list == null || list.next == null) return list;

        ListNode fast = list.next;
        ListNode slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode med = slow.next;
        slow.next = null;

        return merge2List(divideList(list), divideList(med));
    }

    public ListNode sortList(ListNode head) {
        return divideList(head);
    }
}