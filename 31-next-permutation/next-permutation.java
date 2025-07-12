class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int index = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            Arrays.sort(nums);
            return;
        }

        for (int i = n - 1; i >= index; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }

        int left = index + 1, right = n - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }
    }
}