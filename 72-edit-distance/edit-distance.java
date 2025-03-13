class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        if (n1 == 0 || n2 == 0)
            return Math.max(n1, n2);
        if (word1.equals(word2)) return 0;

        int[][] memo = new int[n1][n2];
        for (int[] i: memo) {
            Arrays.fill(i, -1);
        }

        return helper(word1, 0, n1, word2, 0, n2, memo);
    }

    private int helper(String w1, int p1, int n1, String w2, int p2, int n2, int[][] memo) {
        if (p2 == n2) {
            return n1 - p1;
        }
        if (p1 == n1) {
            return n2 - p2;
        }

        if (memo[p1][p2] != -1) {
            return memo[p1][p2];
        }

        int res = -1;
        if (w1.charAt(p1) == w2.charAt(p2)) {
            res = helper(w1, p1 + 1, n1, w2, p2 + 1, n2, memo);
        } else {
            // insert
            int c1 = helper(w1, p1, n1, w2, p2 + 1, n2, memo) + 1;

            // delete
            int c2 = helper(w1, p1 + 1, n1, w2, p2, n2, memo) + 1;

            // replace
            int c3 = helper(w1, p1 + 1, n1, w2, p2 + 1, n2, memo) + 1;

            res = Math.min(c1, Math.min(c2, c3));
        }

        return memo[p1][p2] = res;
    }
}