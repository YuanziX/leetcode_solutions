class Solution {
    public int rob(int[] nums) {
        int p1 = 0, p2 = 0;
        int b1 = 0, b2 = 0;
        if (nums.length == 1) return nums[0];        

        for (int i = 0; i < nums.length - 1; i++) {
            int t1 = p1;
            p1 = Math.max(p1, b1 + nums[i]);
            b1 = t1;
        }

        for (int i = 1; i < nums.length; i++) {
            int t2 = p2;
            p2 = Math.max(p2, b2 + nums[i]);
            b2 = t2;
        }

        return Math.max(p1, p2);
    }
}