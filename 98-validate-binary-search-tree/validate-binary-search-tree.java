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
    private long currentMax = Long.MIN_VALUE;
    private boolean result = true;
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return result;
    }

    public void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        if (node.val <= currentMax) {
            result = false;
            return;
        }

        currentMax = node.val;
        inOrder(node.right);
    }
}