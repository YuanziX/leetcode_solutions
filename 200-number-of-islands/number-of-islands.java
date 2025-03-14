class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int num = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    markAdj(n, m, i, j, grid);
                }
            }
        }

        return num;
    }

    void markAdj(int n, int m, int r, int c, char[][] grid) {
        if (r < 0 || r > n - 1 || c < 0 || c > m - 1 || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        markAdj(n, m, r + 1, c, grid);
        markAdj(n, m, r - 1, c, grid);
        markAdj(n, m, r, c + 1, grid);
        markAdj(n, m, r, c - 1, grid);
    }
}