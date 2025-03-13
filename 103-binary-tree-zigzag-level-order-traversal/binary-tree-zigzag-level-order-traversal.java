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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean insertFirst = false;

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> sub = new LinkedList<>();

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                
                if (insertFirst) {
                    sub.addFirst(node.val);
                } else {
                    sub.addLast(node.val);
                }

                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }

            insertFirst = !insertFirst;
            res.add(sub);
        }

        return res;
    }
}