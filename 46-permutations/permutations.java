class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length == 0) return res;

        helper(nums, new LinkedList<Integer>(), res);
        return res;
    }
    
    private void helper(int[] nums, List<Integer> sub, List<List<Integer>> res) {
        if (sub.size() == nums.length) {
            res.add(new ArrayList<>(sub));
            return;
        }

        for (int i : nums) {
            if (!sub.contains(i)) {
                sub.add(i);
                helper(nums, sub, res);
                sub.remove(sub.size() - 1);
            }
        }
    }
}