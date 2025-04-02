class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l = 0, r = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (r < n) {
            sum += nums[r++];

            while (l < r && sum >= target) {
                min = Math.min(r - l, min);
                sum -= nums[l++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}