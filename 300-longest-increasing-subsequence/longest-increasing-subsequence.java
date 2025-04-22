class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {
                int c1 = 0;
                if (prev == -1 || nums[i] > nums[prev]) {
                    c1 = 1 + dp[i + 1][i + 1];
                }
                int c2 = dp[i + 1][prev + 1];
                dp[i][prev + 1] = Math.max(c1, c2);
            }
        }

        return dp[0][0];
    }
}
