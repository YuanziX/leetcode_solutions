/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void addToQueue(TreeNode node, PriorityQueue<Integer> pq) {
        if (node == null)
            return;
        pq.add(node.val);
        addToQueue(node.left, pq);
        addToQueue(node.right, pq);
    }

    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        addToQueue(root, pq);
        
        while (k != 1) {
            pq.poll();
            k--;
        }

        return pq.poll();
    }
}