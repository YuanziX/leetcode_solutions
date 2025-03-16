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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        helper(root);
        int t = first.val;
        first.val = second.val;
        second.val = t;
    }

    private void helper(TreeNode root) {
        if (root == null) return;

        helper(root.left);

        if (first == null && root.val < prev.val) {
            first = prev;
        }
        if (first != null && root.val < prev.val) {
            second = root;
        }

        prev = root;

        helper(root.right);
    }
}