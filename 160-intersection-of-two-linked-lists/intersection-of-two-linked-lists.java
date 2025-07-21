/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    int getLen(ListNode head) {
        ListNode curr = head;
        int len = 0;
        
        while (curr != null) {
            curr = curr.next;
            len++;
        }

        return len;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = getLen(headA);
        int b = getLen(headB);

        if (b > a) {
            ListNode temp = headA;
            headA = headB;
            headB = temp;

            int t = a;
            a = b;
            b = t;
        }

        for (int i = 0; i < a - b; i++) {
            headA = headA.next;
        }

        while (headA != null && headB != null) {
            if (headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}