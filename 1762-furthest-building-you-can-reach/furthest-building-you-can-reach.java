class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];

            if (diff > 0) {
                if (pq.size() < ladders) {
                    pq.add(diff);
                } else {
                    if (!pq.isEmpty() && pq.peek() < diff && pq.peek() <= bricks) {
                        bricks -= pq.poll();
                        pq.add(diff);
                    } else if (bricks >= diff) {
                        bricks -= diff;
                    } else {
                        return i;
                    }
                }
            }
        }

        return heights.length - 1;
    }
}
