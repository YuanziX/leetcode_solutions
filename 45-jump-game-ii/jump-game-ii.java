class Solution {
    private static int helper(int[] arr, int n, int i, int[] memo) {
        if (n == i) return 0;
        if (memo[i] != -1) return memo[i];
        int jumps = Integer.MAX_VALUE;

        for (int j = 1; j <= arr[i]; j++) {
            if (i + j > n) continue;
            int next = helper(arr, n, i + j, memo);
            if (next == Integer.MAX_VALUE) continue;
            jumps = Math.min(jumps, 1 + next);
        }

        return memo[i] = jumps;
    }

    public static int jump(int[] arr) {
        int N = arr.length;
        int[] memo = new int[N];
        for (int i = 0; i < N; i++) {
            memo[i] = -1;
        }

        int n = helper(arr, N - 1, 0, memo);
        return n == Integer.MAX_VALUE ? -1 : n;
    }
}