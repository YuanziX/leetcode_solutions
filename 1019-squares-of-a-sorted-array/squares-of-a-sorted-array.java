class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length - 1, i = nums.length - 1;
        int[] res = new int[r + 1];

        while (l <= r) {
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                res[i] = nums[l] * nums[l];
                l++;
            } else {
                res[i] = nums[r] * nums[r];
                r--;
            }

            i--;
        }

        return res;
    }
}