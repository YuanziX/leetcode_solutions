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
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode node, int num) {
        num = num * 10 + node.val;
        if (node.left == null && node.right == null) return num;
        if (node.left == null && node.right != null) {
            return helper(node.right, num);
        }
        if (node.left != null && node.right == null) {
            return helper(node.left, num);
        }

        return helper(node.left, num) + helper(node.right, num);
    }
}