class Solution {
    public int fib(int n) {
        Integer[] memo = new Integer[n + 1];
        return fibo(n, memo);
    }

    public int fibo(int n, Integer[] memo) {
        if (n <= 0) return 0;
        if (n <= 1) return n;
        if (memo[n] != null) return memo[n];

        int res = fib(n - 1) + fib(n - 2);
        memo[n] = res;
        return res;
    }
}