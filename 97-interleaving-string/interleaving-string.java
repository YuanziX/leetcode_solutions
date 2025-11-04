class Solution {
    private boolean helper(String s1, String s2, String s3, int l1, int l2, int l3, int p1, int p2, int p3, int[][] dp) {
        if (p1 == l1 && p2 == l2 && p3 == l3) return true;
        if (p3 == l3) return false;

        if (dp[p1][p2] != 0) {
            return dp[p1][p2] == 1;
        }

        boolean res = false;

        if (p1 < l1 && s1.charAt(p1) == s3.charAt(p3)) {
            res = res || helper(s1, s2, s3, l1, l2, l3, p1 + 1, p2, p3 + 1, dp);
        }

        if (p2 < l2 && s2.charAt(p2) == s3.charAt(p3)) {
            res = res || helper(s1, s2, s3, l1, l2, l3, p1, p2 + 1, p3 + 1, dp);
        }

        dp[p1][p2] = res ? 1 : -1;
        return res;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        return helper(s1, s2, s3, s1.length(), s2.length(), s3.length(), 0, 0, 0, dp);
    }
}