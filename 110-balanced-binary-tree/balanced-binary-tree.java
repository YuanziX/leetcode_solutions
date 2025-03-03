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
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        getDepth(root, 0);
        return result;
    }

    private int getDepth(TreeNode node, int depth) {
        if (node == null) return depth;

        int d1 = getDepth(node.left, depth + 1);
        int d2 = getDepth(node.right, depth + 1);

        if (Math.abs(d1 - d2) > 1) result = false;

        return Math.max(d1, d2);
    }
}