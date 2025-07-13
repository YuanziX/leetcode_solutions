class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashSet<List<Integer>> res = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> hs = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int t = - (nums[i] + nums[j]);
                if (hs.contains(t)) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], t);
                    Collections.sort(temp);
                    res.add(temp);
                }
                hs.add(nums[j]);
            }
        }

        return new ArrayList<>(res);
    }
}