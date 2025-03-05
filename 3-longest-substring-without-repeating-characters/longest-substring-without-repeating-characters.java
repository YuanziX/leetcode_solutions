class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> res = new HashSet<>(128);
        int max = 0;
        int i = 0, j = 0;

        while (j < s.length()) {
            if (!res.contains(s.charAt(j))) {
                res.add(s.charAt(j++));
                max = Math.max(max, res.size());
            } else {
                res.remove(s.charAt(i++));
            }
        }

        return max;
    }
}