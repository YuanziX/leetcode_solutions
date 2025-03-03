class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int c = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum;
        
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            if (sum > max) {
                max = sum;
            }
        }
        System.gc();

        return (double) max / k;
    }
}