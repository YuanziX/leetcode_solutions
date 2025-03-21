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
    TreeNode help = null;
    public void flatten(TreeNode root) {
        if (root == null) return;

        if (root.right != null)
            flatten(root.right);
        
        if (root.left != null)
            flatten(root.left);
        
        root.left = null;
        root.right = help;
        help = root;
    }
}