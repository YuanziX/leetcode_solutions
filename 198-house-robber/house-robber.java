class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2){
            return Math.max(nums[0], nums[1]);
        } 
        
        int prev = 0;
        int before = 0;

        for (int i: nums) {
            int temp = prev;
            prev = Math.max(before + i, prev);
            before = temp;
        }

        return prev;
    }
}