class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int profit = 0;

        for (int i : prices) {
            if (i - min > profit)
                profit = i - min;
            if (i < min) {
                min = i;
            }
        }

        return profit;
    }
}