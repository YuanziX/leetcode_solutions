class Solution {
    private boolean helper(String s, String p, int p1, int p2) {
        int l1 = s.length(), l2 = p.length();
        if (p2 == l2) return p1 == l1;

        boolean firstMatch = (p1 < l1 && (s.charAt(p1) == p.charAt(p2) || p.charAt(p2) == '.'));

        if (p2 + 1 < l2 && p.charAt(p2 + 1) == '*') {
            return helper(s, p, p1, p2 + 2) || (firstMatch && helper(s, p, p1 + 1, p2));
        } else {
            return firstMatch && helper(s, p, p1 + 1, p2 + 1);
        }
    }

    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }
}
