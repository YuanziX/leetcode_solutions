class Solution {
    public static int jump(int[] arr) {
        int N = arr.length;
        int[] dp = new int[N];
        for (int i = 0; i < N - 1; i++) {
            dp[i] = 100000;
        }

        for (int i = N - 2; i >= 0; i--) {
            for (int jp = 1; jp <= arr[i] && i + jp < N; jp++) {
                dp[i] = Math.min(dp[i], 1 + dp[i + jp]);
            }
        }

        return dp[0];    
    }
}