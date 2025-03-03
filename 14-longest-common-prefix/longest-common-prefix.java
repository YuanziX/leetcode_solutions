class Solution {
    public String longestCommonPrefix(String[] strs) {
        int minLength = findMinLength(strs);
        int prefix = 0;
        for (int i = 0; i < minLength; i++) {
            char current = strs[0].charAt(i);
            for (String s: strs) {
                if (s.charAt(i) != current) {
                    return s.substring(0, prefix);
                }
            }
            prefix++;
        }

        return strs[0].substring(0, prefix);
    }

    public int findMinLength(String[] strs) {
        int min = Integer.MAX_VALUE;

        for (String s: strs) {
            if (s.length() < min) {
                min = s.length();
            }
        }

        return min;
    }
}