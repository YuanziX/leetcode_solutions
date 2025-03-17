class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int p = 0;

        for (int i : prices) {
            if (i < min) min = i;
            if (i - min > p) p = i - min;
        }

        return Math.max(0, p);
    }

}