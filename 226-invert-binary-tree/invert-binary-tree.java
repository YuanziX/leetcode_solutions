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
    public TreeNode invertTree(TreeNode root) {
        System.gc();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode temp = null;

        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                temp = stack.peek().right;

                if (temp == null) {
                    temp = stack.pop();
                    invert(temp);
                    while (!stack.isEmpty() && stack.peek().right == temp) {
                        temp = stack.pop();
                        invert(temp);
                    }
                } else {
                    node = temp;
                }
            }
        }

        return root;
    }

    private void invert(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}