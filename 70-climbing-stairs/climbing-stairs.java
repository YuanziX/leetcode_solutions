class Solution {
    public int climbStairs(int n) {
        // int[] memo = new int[n + 1];

        // Arrays.fill(memo, -1);

        // for (int i = 0; i < n; i++) {
            
        // }

        return tabulation(n);
    }

    private int tabulation(int n) {

        int[] memo = new int[n + 1];
        memo[n] = 1;
        memo[n - 1] = 1;

        for (int i = n - 2; i >= 0; i--) {
            int n1 = memo[i + 1], n2 = memo[i + 2];
            memo[i] = n1 + n2;
        }
        return memo[0];
    }

    public int helper(int n, int i, int[] memo) {
        if (i == n) return 1;
        if (i > n) return 0;

        int n1 = 0, n2 = 0;
        if (memo[i] != -1) {
            n1 = memo[i];
        } else {
            n1 = helper(n, i + 1, memo);
            memo[i] = n1;
        }

        if (memo[i + 1] != -1) {
            n2 = memo[i + 1];
        } else {
            n2 = helper(n, i + 2, memo);
            memo[i + 1] = n2;
        }

        return n1 + n2;
    }
}