class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] res = new int[2];
        int nums = grid.length * grid[0].length;
        int[] aux = new int[nums];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int num = grid[i][j];
                if (aux[num - 1] == num) {
                    res[0] = num;
                }
                aux[num - 1] = num;
            }
        }
        for (int i = 0; i < aux.length; i++) {
            if (aux[i] == 0) {
                res[1] = i + 1;
                break;
            }
        }

        return res;
    }
}