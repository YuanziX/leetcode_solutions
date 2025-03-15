class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int l = 0, r = n * m - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (matrix[mid / m][mid % m] < target) {
                l = mid + 1;
            } else if (matrix[mid / m][mid % m] > target) {
                r = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}