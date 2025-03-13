class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length()][p.length()];
        for (Boolean[] i: memo) {
            Arrays.fill(i, null);
        }

        return helper(s, p, s.length(), p.length(), 0, 0, memo);
    }

    private boolean helper(String s, String p, int n1, int n2, int p1, int p2, Boolean[][] memo) {
        if (p1 == n1) {
            while (p2 <  n2) {
                if (p.charAt(p2++) != '*') {
                    return false;
                }
            }
            return true;
        } else if (p2 == n2) {
            return n1 == p1;
        }

        if (memo[p1][p2] != null) {
            return memo[p1][p2];
        }

        boolean res = false;
        if (s.charAt(p1) == p.charAt(p2) || p.charAt(p2) == '?') {
            res = helper(s, p, n1, n2, p1 + 1, p2 + 1, memo);
        } else if (p.charAt(p2) == '*') {
            // treat * as nothing
            boolean c1 = helper(s, p, n1, n2, p1, p2 + 1, memo);
            // treat * as sequence
            boolean c2 = helper(s, p, n1, n2, p1 + 1, p2, memo);

            res = c1 || c2;
        }

        return memo[p1][p2] = res;
    }
}