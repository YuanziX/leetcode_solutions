import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new LinkedList<>();

        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return res;
        }

        int r = heights.length;
        int c = heights[0].length;

        boolean[][] pacific = new boolean[r][c];
        boolean[][] atlantic = new boolean[r][c];

        for (int i = 0; i < c; i++) { // vertical
            visitNeighbours(0, i, pacific, heights);
            visitNeighbours(r - 1, i, atlantic, heights);
        }

        for (int i = 0; i < r; i++) { // horizontal
            visitNeighbours(i, 0, pacific, heights);
            visitNeighbours(i, c - 1, atlantic, heights);
        }

        for (int i = 0; i < r; i++) {
            for (int k = 0; k < c; k++) {
                if (atlantic[i][k] && pacific[i][k])
                    res.add(Arrays.asList(i, k));
            }
        }

        return res;
    }

    public void visitNeighbours(int x, int y, boolean[][] visited, int[][] matrix) {
        if (visited[x][y])
            return;
        visited[x][y] = true;

        int[][] direction = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }; // NSEW

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] { x, y });

        while (!q.isEmpty()) {
            int[] pointer = q.poll();

            for (int[] dir : direction) {
                int nextRow = dir[0] + pointer[0];
                int nextCol = dir[1] + pointer[1];
                if (nextRow >= 0 && nextRow < matrix.length && nextCol >= 0 && nextCol < matrix[0].length
                        && !visited[nextRow][nextCol] && matrix[nextRow][nextCol] >= matrix[pointer[0]][pointer[1]]) {
                    q.add(new int[] { nextRow, nextCol });
                    visited[nextRow][nextCol] = true;
                }
            }
        }
    }
}