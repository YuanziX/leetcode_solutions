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
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        
        q.add(root);

        while (!q.isEmpty()) {
            int s = q.size();
            res.add(q.peek().val);

            for (int i = 0; i < s; i++) {
                TreeNode n = q.poll();
                if (n.right != null)
                    q.add(n.right);
                if (n.left != null)
                    q.add(n.left);
            }
        }

        return res;
    }
}