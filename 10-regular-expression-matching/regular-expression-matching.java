class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        boolean[] dp = new boolean[m + 1];
        boolean[] newDp;

        dp[m] = true;

        for (int j = m - 2; j >= 0; j -= 2) {
            if (p.charAt(j + 1) == '*') dp[j] = dp[j + 2];
            else break;
        }

        for (int i = n - 1; i >= 0; i--) {
            newDp = new boolean[m + 1];
            for (int j = m - 1; j >= 0; j--) {
                boolean firstMatch = (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                if (j + 1 < m && p.charAt(j + 1) == '*') {
                    newDp[j] = newDp[j + 2] || (firstMatch && dp[j]);
                } else {
                    newDp[j] = firstMatch && dp[j + 1];
                }
            }
            dp = newDp;
        }

        return dp[0];
    }
}
