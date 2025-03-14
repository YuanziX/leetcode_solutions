class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return rob(nums, nums.length - 1, memo);
    }

    private int rob(int[] nums, int i, int[] memo) {
        if (i < 0) return 0;
        if (memo[i] != -1) return memo[i];

        int c1 = rob(nums, i - 2, memo) + nums[i];
        int c2 = rob(nums, i - 1, memo);

        return memo[i] = Math.max(c1, c2);
    }
}