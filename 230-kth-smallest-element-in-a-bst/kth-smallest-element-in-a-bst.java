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
    void inOrderTraversal(TreeNode node, int k, int[] res) {
        if (node == null || res[1] >= k) {
            return;
        }

        inOrderTraversal(node.left, k, res);
        res[1]++;
        if (res[1] == k) {
            res[0] = node.val;
            return;
        }
        inOrderTraversal(node.right, k, res);
    }

    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[2];

        inOrderTraversal(root, k, res);

        return res[0];
    }
}