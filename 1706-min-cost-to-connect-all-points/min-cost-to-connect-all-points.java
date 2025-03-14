class Solution {

    public int minCostConnectPoints(int[][] points) {
        boolean[] vis = new boolean[points.length];
        // dist, vertex
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[] {0, 0});
        int cost = 0;
        while (!pq.isEmpty()) {
            int[] next = pq.poll();
            int c = next[0];
            int v = next[1];

            if (vis[v]) {
                continue;
            }

            cost += c;
            vis[v] = true;

            for (int i = 0; i < points.length; i++) {
                int dist = Math.abs(points[i][0] - points[v][0]) + Math.abs(points[i][1] - points[v][1]);
                pq.add(new int[]{dist, i});
            }
        }

        return cost;
    }
}