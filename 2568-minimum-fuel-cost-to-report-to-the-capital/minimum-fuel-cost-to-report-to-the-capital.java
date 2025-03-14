class Solution {
    long ans = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        if (roads.length == 0) return 0;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < roads.length + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] i: roads) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }

        dfs(0, 0, adj, seats);
        return ans;
    }

    public int dfs(int i, int prev, List<List<Integer>> adj, int seats) {
        int people = 1;

        for (int x: adj.get(i)) {
            if (x == prev) continue;
            people += dfs(x, i, adj, seats);
        }

        if (i != 0) ans += people / seats + (people % seats == 0 ? 0 : 1);
        return people;
    }
}