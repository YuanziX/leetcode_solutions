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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> subRes = new ArrayList<>();

            for (int ind = 0; ind < n; ind++) {
                TreeNode current = q.poll();
                subRes.add(current.val);

                if (current.left != null) {
                    q.add(current.left);
                }
                
                if (current.right != null) {
                    q.add(current.right);
                }
            }
            list.add(subRes);
        }
        return list;
    }
}
