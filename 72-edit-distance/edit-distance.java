class Solution {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length(), n2 = word2.length();
        int[][] memo = new int[n1][n2];

        for (int[] i: memo) {
            Arrays.fill(i, -1);
        }

        return minDistance(word1, word2, 0, 0, n1, n2, memo);
    }

    private int minDistance(String w1, String w2, int p1, int p2, int n1, int n2, int[][] memo) {
        if (p1 == n1) {
            return n2 - p2;
        } else if (p2 == n2) {
            return n1 - p1;
        }

        if (memo[p1][p2] != -1) return memo[p1][p2];

        if (w1.charAt(p1) == w2.charAt(p2)) {
            return memo[p1][p2] = minDistance(w1, w2, p1 + 1, p2 + 1, n1, n2, memo);
        } else {
            // insert
            int c1 = minDistance(w1, w2, p1, p2 + 1, n1, n2, memo) + 1;

            // delete
            int c2 = minDistance(w1, w2, p1 + 1, p2, n1, n2, memo) + 1;

            //replace
            int c3 = minDistance(w1, w2, p1 + 1, p2 + 1, n1, n2, memo) + 1;

            return memo[p1][p2] = Math.min(c1, Math.min(c2, c3));
        }
    }
}