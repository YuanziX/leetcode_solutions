import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

class Solution {

    private void verticalTraversalHelper(TreeNode root, int hd, int level, TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> store) {
        if (root == null) {
            return;
        }

        if (store.containsKey(hd)) {
            if (store.get(hd).containsKey(level)) {
                store.get(hd).get(level).add(root.val);
            } else {
                ArrayList<Integer> sub = new ArrayList<>();
                sub.add(root.val);
                store.get(hd).put(level, sub);
            }
        } else {
            TreeMap<Integer, ArrayList<Integer>> curr = new TreeMap<>();
            ArrayList<Integer> sub = new ArrayList<>();
            sub.add(root.val);
            curr.put(level, sub);
            store.put(hd, curr);
        }
        verticalTraversalHelper(root.left, hd - 1, level + 1, store);
        verticalTraversalHelper(root.right, hd + 1, level + 1, store);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root != null) {
            TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> store = new TreeMap<>();
            verticalTraversalHelper(root, 0, 0, store);
            for (int mainKey: store.keySet()) {
                TreeMap<Integer, ArrayList<Integer>> subStore = store.get(mainKey);
                ArrayList<Integer> subResult = new ArrayList<>();
                for (int key: subStore.keySet()) {
                    Collections.sort(subStore.get(key));
                    for (int val: subStore.get(key)) {
                        subResult.add(val);
                    }
                }
                result.add(subResult);
            }
        }

        return result;
    }
}