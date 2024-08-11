class Solution {
    public int trap(int[] height) {
        int l = 0; int r = height.length - 1;
        int leftMax = height[l]; int rightMax = height[r];
        int vol = 0;

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                if (leftMax < height[l]) leftMax = height[l];
                vol += leftMax - height[l];
            } else {
                r--;
                if (rightMax < height[r]) rightMax = height[r];
                vol += rightMax - height[r];
            }
        }
        return vol;
    }
}