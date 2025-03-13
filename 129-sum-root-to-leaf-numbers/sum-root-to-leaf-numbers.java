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

    public int helper(TreeNode node, int sum) {
        sum = 10 * sum + node.val;
        if (node.left == null && node.right == null)
            return sum;

        if (node.left == null)
            return helper(node.right, sum);
        
        if (node.right == null)
            return helper(node.left, sum);

        int n1 = helper(node.left, sum);
        int n2 = helper(node.right, sum);

        return n1 + n2;
    }
}