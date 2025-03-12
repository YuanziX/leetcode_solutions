class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] merged = new int[n1 + n2];

        int l1 = 0, l2 = 0, ptr = 0;

        while (l1 < n1 && l2 < n2) {
            if (nums1[l1] < nums2[l2]) {
                merged[ptr++] = nums1[l1++];
            } else {
                merged[ptr++] = nums2[l2++];
            }
        }

        while (l1 < n1) {
            merged[ptr++] = nums1[l1++];
        }

        while (l2 < n2) {
            merged[ptr++] = nums2[l2++];
        }
        System.out.println(Arrays.toString(merged));
        if (ptr % 2 != 0) return merged[ptr / 2];
        return ((double) merged[ptr / 2 - 1] + merged[ptr / 2]) / 2;
    }
}