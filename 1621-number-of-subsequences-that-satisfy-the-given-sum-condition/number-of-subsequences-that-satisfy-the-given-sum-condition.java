class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int mod = 1_000_000_000 + 7;
        int ans = 0;
        int l = 0;
        int r = nums.length-1;

        int len = nums.length;

        int[] power = new int[len];
        power[0] = 1;
        for (int i = 1; i < len; ++i) {
            power[i] = (power[i - 1] * 2) % mod;
        }

        while(l<=r) {
            if(nums[l] + nums[r] <= target) {
                int n = r - l;
                ans = (ans + power[n]) % mod;
                l++;
            } else {
                r--;
            }
        }
        return ans;
    }
}