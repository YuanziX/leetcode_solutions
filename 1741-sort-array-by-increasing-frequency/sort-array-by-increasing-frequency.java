import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        quickSort(nums, 0, nums.length - 1, freq);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right, Map<Integer, Integer> freq) {
        if (left >= right) return;

        int pivotIndex = partition(nums, left, right, freq);
        quickSort(nums, left, pivotIndex - 1, freq);
        quickSort(nums, pivotIndex + 1, right, freq);
    }

    private int partition(int[] nums, int left, int right, Map<Integer, Integer> freq) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (compare(nums[j], pivot, freq) < 0) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private int compare(int a, int b, Map<Integer, Integer> freq) {
        int fa = freq.get(a), fb = freq.get(b);
        if (fa != fb) return fa - fb;
        return b - a;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
