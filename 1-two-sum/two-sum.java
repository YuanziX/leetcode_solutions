class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int t = target - nums[i];
            if (n == t) {
                List<Integer> idxs = map.get(t);
                if (idxs.size() > 1) {
                    res[0] = idxs.get(0);
                    res[1] = idxs.get(1);
                    break;
                }
            } else {
                List<Integer> idxs = map.get(t);
                if (idxs == null) continue;
                res[0] = i;
                res[1] = idxs.get(0);
                break;
            }
        }

        return res;
    }
}