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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode m1 = l1;
        ListNode m2 = l2;
        ListNode result = new ListNode(-1);
        ListNode tail = result;

        while (m1 != null && m2 != null) {
            int sum = m1.val + m2.val + carry;
            carry = sum > 9 ? 1 : 0;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            m1 = m1.next;
            m2 = m2.next;
        }

        while (m1 != null) {
            int sum = m1.val + carry;
            carry = sum > 9 ? 1 : 0;
            m1.val = sum % 10;
            tail.next = m1;
            tail = tail.next;
            m1 = m1.next;
        }

        while (m2 != null) {
            int sum = m2.val + carry;
            carry = sum > 9 ? 1 : 0;
            m2.val = sum % 10;
            tail.next = m2;
            tail = tail.next;
            m2 = m2.next;
        }

        if (carry == 1) {
            tail.next = new ListNode(carry);
        }

        return result.next;
    }
}