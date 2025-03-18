class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        for (int[] j: memo) {
            Arrays.fill(j, -1);
        }

        return helper(m, n, 0, 0, memo);
    }

    int helper(int m, int n, int i, int j, int[][] memo) {
        if (i == m - 1 && j == n - 1) return 1;
        if (i >= m || j >= n) return 0;

        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        int n1 = 0, n2 = 0;
        n1 = helper(m, n, i + 1, j, memo);
        n2 = helper(m, n, i, j + 1, memo);

        return memo[i][j] = n1 + n2;
    }
}