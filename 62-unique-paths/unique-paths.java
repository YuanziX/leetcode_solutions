class Solution {
    public int uniquePaths(int m, int n) {
        int[][][] memo = new int[m][n][2];
        for (int[][] i: memo)  {
            for (int[] j: i) {
                Arrays.fill(j, -1);
            }
        }

        return helper(m, n, 0, 0, memo);
    }

    int helper(int m, int n, int i, int j, int[][][] memo) {
        if (i == m - 1 && j == n - 1) return 1;
        if (i >= m || j >= n) return 0;

        int n1 = 0, n2 = 0;
        if (memo[i][j][0] != -1) {
            n1 = memo[i][j][0];
        } else {
            n1 = helper(m, n, i + 1, j, memo);
            memo[i][j][0] = n1;
        }

        if (memo[i][j][1] != -1) {
            n2 = memo[i][j][1];
        } else {
            n2 = helper(m, n, i, j + 1, memo);
            memo[i][j][1] = n2;
        }

        return n1 + n2;
    }
}