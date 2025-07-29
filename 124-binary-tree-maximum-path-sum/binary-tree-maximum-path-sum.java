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
    int maxSum = Integer.MIN_VALUE;

    public int helper(TreeNode root) {
        if (root == null) return 0;

        int a = Math.max(0, helper(root.left));
        int b = Math.max(0, helper(root.right));

        maxSum = Math.max(a + b + root.val, maxSum);

        return Math.max(a, b) + root.val;
    }

    public int maxPathSum(TreeNode root) {
        maxSum = Math.max(helper(root), maxSum);
        return maxSum;
    }
}