class Solution {
    private void swap(int[] nums, int l, int r) {
        int t = nums[r];
        nums[r] = nums[l];
        nums[l] = t;
    }

    private int partition(int[] nums, int l, int r) {
        int piv = nums[l + (r - l) / 2];
        int i = l - 1;
        swap(nums, r, l + (r - l) / 2);

        for (int j = l; j < r; j++) {
            if (nums[j] < piv) {
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, r);
        return i + 1;
    }

    private void qs(int[] nums, int l, int r) {
        if (l < r) {
            int p = partition(nums, l, r);

            qs(nums, l, p - 1);
            qs(nums, p + 1, r);
        }
    }

    public int[] sortArray(int[] nums) {
        qs(nums, 0, nums.length - 1);
        return nums;
    }
}