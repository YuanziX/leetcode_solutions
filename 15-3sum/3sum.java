class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;

            int j = i + 1, k = nums.length - 1;

            while (j < k) {
                int t = nums[i] + nums[j] + nums[k];
                if (t < 0) {
                    j++;
                } else if (t > 0) {
                    k--;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    while (j < k && nums[j + 1] == nums[j]) {
                        j++;
                    }
                    
                    while (j < k && nums[k - 1] == nums[k]) {
                        k--;
                    }

                    j++; k--;
                }
            }
        }
        
        return res;
    }
}