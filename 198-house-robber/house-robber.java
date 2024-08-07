class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;

        int prev = 0;
        int beforePrev = 0;

        for (int num: nums) {
            int tmp = prev;
            prev = Math.max(beforePrev + num, prev);
            beforePrev = tmp;
        }
        return prev;
    }
}