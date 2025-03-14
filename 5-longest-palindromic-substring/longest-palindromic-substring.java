class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] str = s.toCharArray();
        int start = 0, end = 0;

        for (int i = 0; i < str.length; i++) {
            int even = expand(str, i, i+1);
            int odd = expand(str, i, i);
            int max = Math.max(even, odd);
    
            if (max > end - start) {
                start = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    private int expand(char[] s, int l, int r) {
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}