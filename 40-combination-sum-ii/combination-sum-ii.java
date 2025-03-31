class Solution {
    public List<List<Integer>> combinationSum2(int[] cand, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(cand);
        helper(new ArrayList<>(), 0, target, 0, cand, res);
        return res;
    }

    private void helper(List<Integer> sub, int sum, int target, int index, int[] cand, List<List<Integer>> res) {
        if (sum == target) {
            res.add(new ArrayList<>(sub));
            return;
        }

        if (sum > target || index == cand.length) {
            return;
        }

        // pick
        sub.add(cand[index]);
        helper(sub, sum + cand[index], target, index + 1, cand, res);
        sub.remove(sub.size() - 1);
        
        while (index < cand.length - 1 && cand[index + 1] == cand[index]) {
            index++;
        }
        helper(sub, sum, target, index + 1, cand, res);
    }
}