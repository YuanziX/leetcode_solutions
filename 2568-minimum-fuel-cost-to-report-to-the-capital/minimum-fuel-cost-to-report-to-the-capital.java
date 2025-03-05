class Solution {
    static int n;
    static int[] head = new int[200002];
    static int[] next = new int[200002];
    static int[] to = new int[200002];
    static long[] cost = new long[200002];
    static int[] size = new int[200002];
    static int cnt;

    public long minimumFuelCost(int[][] roads, int seats) {
        n = roads.length + 1;
        build();
        for (int[] road : roads) {
            next[cnt] = head[road[0]];
            to[cnt] = road[1];
            head[road[0]] = cnt++;

            next[cnt] = head[road[1]];
            to[cnt] = road[0];
            head[road[1]] = cnt++;
        }
        f(0, -1, seats);
        return cost[0];
    }

    void f(int curr, int prev, int seats) {
        for (int i = head[curr]; i > 0; i = next[i]) {
            if (to[i] != prev) {
                f(to[i], curr, seats);
                size[curr] += size[to[i]];
                cost[curr] += cost[to[i]];
                cost[curr] += (size[to[i]] + seats - 1) / seats;
            }
        }
    }

    private void build() {
        cnt = 1;
        for (int i = 0; i < n; i++) {
            head[i] = 0;
            next[i] = 0;
            to[i] = 0;
            cost[i] = 0;
            size[i] = 1;
        }
    }
}