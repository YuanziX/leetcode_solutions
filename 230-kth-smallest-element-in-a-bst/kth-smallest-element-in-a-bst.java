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
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[]{0, k - 1};
        helper(root, res);
        return res[0];
    }

    private void helper(TreeNode n, int[] res) {
        if (n == null) return;

        helper(n.left, res);

        if (res[1]-- == 0) {
            res[0] = n.val;
            return;
        }

        helper(n.right, res);
    }
}