class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n1 = cost[0], n2 = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int t = n2;
            n2 = cost[i] + Math.min(n1, n2);
            n1 = t;
        }

        return Math.min(n1, n2);
    }
}