class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        if (s1.equals(s2)) {
            return 0;
        }

        int n1 = s1.length(), n2 = s2.length();
        int[][] memo = new int[n1][n2];
        for (int[] i: memo) {
            Arrays.fill(i, -1);
        }

        return helper(s1, s2, 0, 0, n1, n2, memo);
    }

    private int helper(String s1, String s2, int p1, int p2, int n1, int n2, int[][] memo) {
        int res = 0;
        if (p1 == n1) {
            for (int i = p2; i < n2; i++) {
                res += s2.charAt(i);
            }
            return res;
        }
        if (p2 == n2) {
            for (int i = p1; i < n1; i++) {
                res += s1.charAt(i);
            }
            return res;
        }

        if (memo[p1][p2] != -1) {
            return memo[p1][p2];
        }

        if (s1.charAt(p1) == s2.charAt(p2)) {
            res = helper(s1, s2, p1 + 1, p2 + 1, n1, n2, memo);
        } else {
            int c1 = helper(s1, s2, p1 + 1, p2, n1, n2, memo) + s1.charAt(p1);
            int c2 = helper(s1, s2, p1, p2 + 1, n1, n2, memo) + s2.charAt(p2);

            res = Math.min(c1, c2);
        }

        return memo[p1][p2] = res;
    }
}