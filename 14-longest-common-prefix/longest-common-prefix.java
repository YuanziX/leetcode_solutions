class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (a, b) -> a.length() - b.length());

        int prefix = strs[0].length();

        for (String s: strs) {
            for (int i = 0; i < prefix; i++) {
                if (s.charAt(i) != strs[0].charAt(i)) {
                    prefix = i;
                    break;
                }
            }
        }

        return strs[0].substring(0, prefix);
    }
}