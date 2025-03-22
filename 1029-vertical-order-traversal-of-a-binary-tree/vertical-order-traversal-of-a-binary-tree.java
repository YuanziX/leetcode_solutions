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
        if (root == null) return res;

        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        helper(root, 0, 0, map);
        for (Map.Entry<Integer, Map<Integer, PriorityQueue<Integer>>> outer: map.entrySet()) {
            List<Integer> ls = new ArrayList<>();

            for (Map.Entry<Integer, PriorityQueue<Integer>> inner : outer.getValue().entrySet()) {
                while (!inner.getValue().isEmpty()) {
                    ls.add(inner.getValue().poll());
                }
            }

            res.add(ls);
        }

        return res;
    }

    void helper(TreeNode node, int x, int y, Map<Integer, Map<Integer, PriorityQueue<Integer>>> map) {
        if (node == null) return;

        map.computeIfAbsent(x, k -> new TreeMap<>())
        .computeIfAbsent(y, k -> new PriorityQueue<>()).add(node.val);

        helper(node.left, x - 1, y + 1, map);
        helper(node.right, x + 1, y + 1, map);
    } 
}