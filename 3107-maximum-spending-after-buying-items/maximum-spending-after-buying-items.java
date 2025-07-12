class Solution {
    public long maxSpending(int[][] values) {
        int m = values.length, n = values[0].length;
        long spending = 0;

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pq.add((long) values[i][j]);
            }
        }

        int k = 1;
        while (!pq.isEmpty()) {
            spending += pq.poll() * k++;
        }

        return spending;
    }
}