class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l = 0, u = 0;
        int r = matrix[0].length - 1, d = matrix.length - 1;
        int i = 0, j = 0;

        List<Integer> res = new ArrayList<>();

        while (l <= r && u <= d) {
            for (j = l; j <= r; j++) {
                res.add(matrix[u][j]);
            }
            u++;

            for (i = u; i <= d; i++) {
                res.add(matrix[i][r]);
            }
            r--;

            if (u <= d) {
                for (j = r; j >= l; j--) {
                    res.add(matrix[d][j]);
                }
                d--;
            }

            if (l <= r) {
                for (i = d; i >= u; i--) {
                    res.add(matrix[i][l]);
                }
                l++;
            }
        }

        return res;
    }
}