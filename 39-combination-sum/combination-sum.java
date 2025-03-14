class Solution {
    public List<List<Integer>> combinationSum(int[] cand, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(new ArrayList<>(), 0, target, cand.length, cand, res);
        return res;
    }

    private void helper(List<Integer> sub, int sum, int target, int index, int[] cand, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(sub));
            return;
        }

        for (int i = 0; i < index; i++) {
            if (sum + cand[i] > target) continue;

            sub.add(cand[i]);
            helper(sub, sum + cand[i], target, i + 1, cand, res);
            sub.remove(sub.size() - 1);
        }
    }
}