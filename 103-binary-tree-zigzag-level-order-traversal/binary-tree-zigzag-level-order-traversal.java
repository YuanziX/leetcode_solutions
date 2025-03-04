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
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        boolean dirLeft = true;
        while (!q.isEmpty()) {
            List<Integer> al = new ArrayList<>();
            int n = q.size();

            for (int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                if (dirLeft)
                    al.addLast(curr.val);
                else
                    al.addFirst(curr.val);

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            result.add(al);
            dirLeft = !dirLeft;
        }

        return result;
    }
}