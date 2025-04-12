class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums.length == 0) return res;

        boolean[] vis = new boolean[nums.length];
        helper(nums, vis, new ArrayList<Integer>(), res);
        return res;
    }

    private void helper(int[] nums, boolean[] vis, ArrayList<Integer> sub, List<List<Integer>> res) {
        if (sub.size() == nums.length) {
            res.add(new ArrayList<>(sub));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) continue;
            sub.add(nums[i]);
            vis[i] = true;
            helper(nums, vis, sub, res);
            vis[i] = false;
            sub.remove(sub.size() - 1);
        }
    }
}