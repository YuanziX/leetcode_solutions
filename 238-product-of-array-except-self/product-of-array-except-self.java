class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] aux = new int[n];
        for (int i = 0; i < n; i++) {
            aux[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            aux[i] = aux[i - 1] * nums[i - 1];
        }

        int helper = 1;
        for (int j = n - 2; j > -1; j--) {
            helper *= nums[j + 1];
            aux[j] *= helper;
        }

        return aux;
    }
}