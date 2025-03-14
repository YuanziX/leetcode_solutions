class Solution {
    public String longestPrefix(String s) {
        char[] str = s.toCharArray();
        for (int i = str.length - 1; i > -1; i--) {
            if (s.endsWith(s.substring(0, i))) {
                return s.substring(0, i);
            }
        }

        return "";
    }
}