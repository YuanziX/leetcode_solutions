class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1) return 1;
        if (n == 1) return 1;

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = m - 2; i > -1; i--) {
            for (int j = n - 2; j > -1; j--) {
                dp[j] += dp[j + 1];
            }
        }

        return dp[0];
    }
}