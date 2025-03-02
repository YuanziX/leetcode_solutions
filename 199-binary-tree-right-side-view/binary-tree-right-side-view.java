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
        List<Integer> marked = new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        doSum(root, 0, marked, res);

        return res;
    }

    public void doSum(TreeNode node, int level, List<Integer> marked, List<Integer> res) {
        if (node == null) {
            return;
        }

        if (!marked.contains(level)) {
            marked.add(level);
            res.add(node.val);
        }

        doSum(node.right, level + 1, marked, res);
        doSum(node.left, level + 1, marked, res);
    }
}