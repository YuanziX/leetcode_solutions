class Solution {
    public String longestPrefix(String s) {
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.endsWith(s.substring(0, i))) {
                return s.substring(0, i);
            }
        }

        return "";
    }
}