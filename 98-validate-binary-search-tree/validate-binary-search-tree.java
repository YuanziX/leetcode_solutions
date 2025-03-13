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
    public boolean isValidBST(TreeNode root) {
        long[] res = new long[2];
        res[0] = Long.MIN_VALUE;
        res[1] = 1;
        helper(root, res);
        return res[1] == 1;
    }

    public void helper(TreeNode node, long[] res) {
        if (node == null) return;

        helper(node.left, res);

        if (node.val <= res[0]) {
            res[1] = 0;
            return;
        }

        res[0] = node.val;
        helper(node.right, res);
    }
}