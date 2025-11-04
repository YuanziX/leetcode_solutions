class Solution {
    private Boolean[][] memo;

    private boolean helper(String s, String p, int i, int j) {
        int n = s.length(), m = p.length();

        if (memo[i][j] != null) return memo[i][j];

        boolean ans;

        if (j == m) {
            ans = (i == n);
        } else {
            boolean firstMatch = (i < n && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

            if (j + 1 < m && p.charAt(j + 1) == '*') {
                ans = helper(s, p, i, j + 2) || (firstMatch && helper(s, p, i + 1, j));
            } else {
                ans = firstMatch && helper(s, p, i + 1, j + 1);
            }
        }

        memo[i][j] = ans;
        return ans;
    }

    public boolean isMatch(String s, String p) {
        memo = new Boolean[s.length() + 1][p.length() + 1];
        return helper(s, p, 0, 0);
    }
}
