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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        helper(root, 0, res);
        return res;
    }

    private void helper(TreeNode node, int l, List<Integer> q) {
        if (node == null) return;

        if (q.size() == l) {
            q.add(node.val);
        }

        helper(node.right, l + 1, q);
        helper(node.left, l + 1, q);
    }
}