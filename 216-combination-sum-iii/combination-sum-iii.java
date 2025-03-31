class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, 1, k, n, new ArrayList<>(), res);
        return res;
    }

    private void helper(int sum, int i, int k, int t, List<Integer> sub, List<List<Integer>> res) {
        if (sum == t && k == 0) {
            res.add(new ArrayList<>(sub));
            return;
        }

        if (i > 9) return;

        if (sum + i <= t) {
            // pick
            sub.add(i);
            helper(sum + i, i + 1, k - 1, t, sub, res);
            sub.remove(sub.size() - 1);
        }

        // skip
        helper(sum, i + 1, k, t, sub, res);
    }
}