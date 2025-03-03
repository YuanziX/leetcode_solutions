class Solution {
    public int fib(int n) {
        if (n < 2) return n;

        Integer[] memo = new Integer[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        return fibo(n, memo);
    }

    public int fibo(int n, Integer[] memo) {
        if (memo[n] != null) return memo[n];

        int res = fib(n - 1) + fib(n - 2);
        memo[n] = res;
        return res;
    }
}