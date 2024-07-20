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
    public ListNode deleteDuplicates(ListNode head) {
        Set<Integer> uniques = new HashSet<>();
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            if (uniques.contains(current.val)) {
                prev.next = current.next;
            } else {
                uniques.add(current.val);
                prev = current;
            }
            current = current.next;
        }
        return head;
    }
}