/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return recurse(root, p, q);
    }

    private TreeNode recurse(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || node == p || node == q) return node;

        TreeNode left = recurse(node.left, p, q);
        TreeNode right = recurse(node.right, p, q);

        if (left != null && right != null) {
            return node;
        } else if (left == null) {
            return right;
        } else {
            return left;
        }
    }
}