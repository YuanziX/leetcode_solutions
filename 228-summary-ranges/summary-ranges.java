class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length < 1) return result;
        int currentContinous = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - 1 != nums[i - 1]) {
                if (currentContinous == 0) {
                    result.add(Integer.toString(nums[i - 1]));
                    continue;
                }

                result.add((nums[i - 1] - currentContinous) + "->" + nums[i-1]);
                currentContinous = 0;
                continue;
            }
            currentContinous++;
        }
        if (currentContinous != 0) {
            result.add((nums[nums.length - 1] - currentContinous) + "->" + nums[nums.length-1]);
        } else {
            result.add(Integer.toString(nums[nums.length-1]));
        }

        return result;
    }
}