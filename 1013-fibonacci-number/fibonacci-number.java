class Solution {
    public int fib(int n) {
        if (n < 2) return n;

        Integer[] memo = new Integer[n + 1];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n];
    }
}