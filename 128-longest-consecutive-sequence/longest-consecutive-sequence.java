class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i: nums) s.add(i);

        int max = 0;

        for (int i: s) {
            if (!s.contains(i - 1)) {
                int j  = i;
                int n = 1;

                while (s.contains(j + 1)) {
                    j++;
                    n++;
                }
                max = Math.max(n, max);
            }
        }

        return max;
    }
}