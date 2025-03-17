class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return tabulation(cost);
    }

	public int tabulation(int[] cost) {
		int n = cost.length;
		int[] dp = new int[n];

		dp[n - 1] = cost[n - 1];
		dp[n - 2] = cost[n - 2];

		for (int i = n - 3; i >= 1; i--) {
			dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
		}
		int c1 = dp[1];

		for (int i = n - 3; i >= 0; i--) {
			dp[i] = cost[i] + Math.min(dp[i + 1], dp[i + 2]);
		}

		return Math.min(dp[0], c1);
	}
}