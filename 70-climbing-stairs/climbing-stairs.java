class Solution {
    public int climbStairs(int n) {
        return tabulation(n);
    }

    private int tabulation(int n) {
        int i1 = 1;
        int i2 = 1;

        for (int i = n - 2; i >= 0; i--) {
            int t = i2;
            i2 = i1;
            i1 = i2 + t;
        }
        return i1;
    }
}