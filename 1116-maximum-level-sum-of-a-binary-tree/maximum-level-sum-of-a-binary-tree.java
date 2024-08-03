/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int maxLevelSum(TreeNode root) {
        if (root == null)
            return 0;
        int maxSum = Integer.MIN_VALUE;
        int level = 0;
        int tempLevel = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            tempLevel++;
            int n = q.size();
            int tempSum = 0;

            for (int i = 0; i < n; i++) {
                TreeNode current = q.poll();

                tempSum += current.val;

                if (current.left != null) {
                    q.add(current.left);
                }

                if (current.right != null) {
                    q.add(current.right);
                }
            }

            if (tempSum > maxSum) {
                maxSum = tempSum;
                level = tempLevel;
            }
        }

        return level;
    }
}