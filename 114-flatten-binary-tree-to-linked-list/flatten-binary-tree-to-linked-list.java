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
    public void flatten(TreeNode root) {
        if (root == null)
            return;

        TreeNode dummy = new TreeNode(-1);
        TreeNode tail = dummy;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while (st.empty() == false) {
            TreeNode node = st.pop();
            TreeNode temp = node.left;
            node.left = null;
            tail.right = node;
            tail = tail.right;

            if (node.right != null) {
                st.push(node.right);
            }
            if (temp != null) {
                st.push(temp);
            }
        }

        root = dummy.right;
    }
}