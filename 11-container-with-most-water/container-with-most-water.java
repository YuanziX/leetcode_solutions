class Solution {
    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;

        int vol = Integer.MIN_VALUE;
        while (l < r) {
            int newVol = Math.min(heights[l], heights[r]) * (r - l);
            vol = Math.max(newVol, vol);

            if (heights[l] < heights[r]) l++;
            else r--;
        }

        return vol;
    }
}
