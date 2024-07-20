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
    public ListNode partition(ListNode head, int x) {
        ListNode lesser = new ListNode(0);
        ListNode greater = new ListNode(0);
        ListNode modifyLess = lesser;
        ListNode modifyMore = greater;
        
        while (head != null) {
            if (head.val < x) {
                modifyLess.next = new ListNode(head.val);
                modifyLess = modifyLess.next;
            } else {
                modifyMore.next = new ListNode(head.val);
                modifyMore = modifyMore.next;
            }
            head = head.next;
        }
        modifyLess.next = greater.next;
        
        return lesser.next;  
    }
}