class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n][n+1];
        for (int[] i: memo) {
            Arrays.fill(i, -1);
        }

        return helper(-1, 0, nums, memo);
    }

    public int helper(int prev, int i, int[] nums, int[][] memo) {
        if (i == nums.length) return 0;
        if (memo[i][prev+1] != -1) return memo[i][prev+1];

        int c1 = 0;
        if (prev == -1 || nums[i] > nums[prev]) {
            c1 = helper(i, i + 1, nums, memo) + 1;
        }
        int c2 = helper(prev, i + 1, nums, memo);

        return memo[i][prev+1] = Math.max(c1, c2);
    }
}