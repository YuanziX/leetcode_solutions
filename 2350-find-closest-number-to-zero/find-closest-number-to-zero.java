class Solution {
    public int findClosestNumber(int[] nums) {
        int minDistance = Integer.MAX_VALUE;
        int num = 0;

        for (int i: nums) {
            int dist = Math.abs(i);

            if (dist == minDistance) {
                if (i > num) {
                    minDistance = dist;
                    num = i;
                }
                continue;
            }

            if (dist < minDistance) {
                minDistance = dist;
                num = i;
            }
        }
        return num;
    }
}