class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = Integer.MIN_VALUE;
        int ptr = 0;

        for (int i = 0; i < nums.length; i++) {
            if (dp[ptr] < nums[i]) {
                ptr++;
                dp[ptr] = nums[i];
            } else {
                dp[lowerBound(dp, ptr + 1, nums[i])] = nums[i];
            }
        }

        return ptr;
    }

    public static int lowerBound(int []arr, int n, int x) {
        int ans = n;

        int l = 0, r = n - 1;

        while (l <= r) {
            int m = (l + r) / 2;

            if (arr[m] >= x) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return ans;
    }
}