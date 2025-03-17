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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        Map<Integer, Map<Integer, PriorityQueue<Integer>>> hm = new TreeMap<>();

        helper(root, 0, 0, hm);

        for (Map.Entry<Integer, Map<Integer, PriorityQueue<Integer>>> outer : hm.entrySet()) {
            List<Integer> sub = new ArrayList<>();

            for (Map.Entry<Integer, PriorityQueue<Integer>> inner : outer.getValue().entrySet()) {
                // Collections.sort(inner.getValue());

                while (!inner.getValue().isEmpty()) {
                    sub.add(inner.getValue().poll());
                }
            }
            res.add(sub);
        }
        return res;
    }

    public void helper(TreeNode node, int x, int y, Map<Integer, Map<Integer, PriorityQueue<Integer>>> hm) {
        if (node == null)
            return;

        hm.computeIfAbsent(x, k -> new TreeMap<>())
                .computeIfAbsent(y, k -> new PriorityQueue<>())
                .add(node.val);

        helper(node.left, x - 1, y + 1, hm);
        helper(node.right, x + 1, y + 1, hm);
    }
}