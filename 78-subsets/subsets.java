class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), res);
        return res;
    }

    private void helper(int[] nums, int i, List<Integer> sub, List<List<Integer>> res) {
        res.add(new ArrayList<>(sub));

        for (int j = i; j < nums.length; j++) {
            sub.add(nums[j]);
            helper(nums, j + 1, sub, res);
            sub.remove(sub.size() - 1);
        }
    }
}