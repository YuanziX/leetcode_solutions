class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) return nums1[i];

            while (i < nums1.length && j < nums2.length && nums1[i] < nums2[j]) {
                i++;
            }

            while (i < nums1.length && j < nums2.length && nums2[j] < nums1[i]) {
                j++;
            }
        }

        return -1;
    }
}