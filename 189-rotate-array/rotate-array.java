class Solution {
	public void rotate(int[] nums, int k) {
        k = k % nums.length;
		int split = nums.length - k;

		for (int i = 0; i < split / 2; i++) {
			int t = nums[i];
			nums[i] = nums[split - i - 1];
			nums[split - i - 1] = t;
		}

		for (int i = 0; i < k / 2; i++) {
			int t = nums[i + split];
			nums[i + split] = nums[nums.length - i - 1];
			nums[nums.length - i - 1] = t;
		}

		for (int i = 0; i < nums.length / 2; i++) {
			int t = nums[i];
			nums[i] = nums[nums.length - i - 1];
			nums[nums.length - i - 1] = t;
		}
	}
}