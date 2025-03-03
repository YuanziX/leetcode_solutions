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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getHeight(root, 1);
    }

        public int getHeight(TreeNode node, int height) {
        if (node.left == null && node.right == null) {
            return height;
        } else {
            int h1 = height, h2 = height;
            if (node.left != null) {
                h1 = getHeight(node.left, height + 1);
            }

            if (node.right != null) {
                h2 = getHeight(node.right, height + 1);
            }
            return Math.max(h1, h2);
        }
    }
}