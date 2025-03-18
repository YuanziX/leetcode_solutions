class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 1 && n == 1) return 1;
        if (m == 1) return 1;
        if (n == 1) return 1;

        int[][] memo = new int[m][n];

        memo[m - 1][n - 1] = 0;
        memo[m - 2][n - 1] = 1;
        memo[m - 1][n - 2] = 1;
        
        for (int i = m - 1; i > -1; i--) {
            for (int j = n - 1; j > -1; j--) {
                if (i < m - 1)
                    memo[i][j] += memo[i + 1][j];
                if (j < n - 1)
                    memo[i][j] += memo[i][j + 1];
            }
        }

        return memo[0][0];
    }
}