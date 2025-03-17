class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];

        Arrays.fill(memo, -1);
        return helper(n, 0, memo);
    }

    public int helper(int n, int i, int[] memo) {
        if (i == n) return 1;
        if (i > n) return 0;

        int n1 = 0, n2 = 0;
        if (i + 1 <= n) {
            if (memo[i] != -1) {
                n1 = memo[i];
            } else {
                n1 = helper(n, i + 1, memo);
                memo[i] = n1;
            }
        }

        if (i + 2 <= n) {
            if (memo[i + 1] != -1) {
                n2 = memo[i + 1];
            } else {
                n2 = helper(n, i + 2, memo);
                memo[i + 1] = n2;
            }
        }

        return n1 + n2;
    }
}