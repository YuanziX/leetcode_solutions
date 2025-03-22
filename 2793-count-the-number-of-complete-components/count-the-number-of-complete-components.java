class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] sd: edges) {
            adj.get(sd[0]).add(sd[1]);
            adj.get(sd[1]).add(sd[0]);
        }

        boolean[] vis = new boolean[n];
        int cc = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            cc += dfs(i, vis, adj);
        }

        return cc;
    }

    int dfs(int v, boolean[] vis, List<List<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        st.add(v);

        int e = 0;
        int V = 1;

        while (!st.isEmpty()) {
            int u = st.pop();

            for (int i : adj.get(u)) {
                e++;
                if (!vis[i]) {
                    V++;
                    vis[i] = true;
                    st.push(i);
                };
            }
        }

        return e/2 == V*(V-1)/2 ? 1 : 0;
    }
}