class Solution {
    public int minCostClimbingStairs(int[] cost) {
        return tabulation(cost);
    }

	public int tabulation(int[] cost) {
        if (cost.length == 2) return Math.min(cost[0], cost[1]);

		int n = cost.length;

		int i2 = cost[n - 1], i1 = cost[n - 2];

		for (int i = n - 3; i >= 1; i--) {
			int t = i1;
			i1 = cost[i] + Math.min(i1, i2);
			i2 = t;
		}
		int c1 = i1;
		i2 = cost[n - 1];
		i1 = cost[n - 2];

		for (int i = n - 3; i >= 0; i--) {
			int t = i1;
			i1 = cost[i] + Math.min(i1, i2);
			i2 = t;
		}

		return Math.min(c1, i1);
	}
}