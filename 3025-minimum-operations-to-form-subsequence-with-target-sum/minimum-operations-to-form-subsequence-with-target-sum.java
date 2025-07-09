class Solution {
    public int minOperations(List<Integer> nums, int target) {
        long sum = 0;
        for (int i: nums) sum += i;

        if (sum < target) return -1;

        Collections.sort(nums);

        int res = 0;

        while (target > 0) {
            int a = nums.remove(nums.size() - 1);

            if (sum - a >= target) {
                sum -= a;
            } else if (a <= target) {
                sum -= a;
                target -= a;
            } else {
                nums.add(a / 2);
                nums.add(a / 2);
                res++;
            }
        }

        return res;
    }
}