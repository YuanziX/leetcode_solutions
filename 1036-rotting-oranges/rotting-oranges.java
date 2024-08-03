class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int minutes = 0;
        boolean changed;

        while (true) {
            changed = false;
            int[][] newGrid = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    newGrid[i][j] = grid[i][j];
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 2) {
                        if (i > 0 && grid[i - 1][j] == 1) {
                            newGrid[i - 1][j] = 2;
                            changed = true;
                        }
                        if (i < rows - 1 && grid[i + 1][j] == 1) {
                            newGrid[i + 1][j] = 2;
                            changed = true;
                        }
                        if (j > 0 && grid[i][j - 1] == 1) {
                            newGrid[i][j - 1] = 2;
                            changed = true;
                        }
                        if (j < cols - 1 && grid[i][j + 1] == 1) {
                            newGrid[i][j + 1] = 2;
                            changed = true;
                        }
                    }
                }
            }

            grid = newGrid;

            if (!changed) break;
            minutes++;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }

        return minutes;
    }
}
