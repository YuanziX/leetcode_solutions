class Solution {
    static class Edge implements Comparable<Edge> {
        int s, d, w;
        public Edge(int s, int d, int w) {
            this.s = s;
            this.d = d;
            this.w = w;
        }

        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    static class DisjointSet {
        int[] rank;
        int[] parent;

        public DisjointSet(int v) {
            rank = new int[v];
            parent = new int[v];

            for (int i = 0; i < v; i++) {
                rank[i] = 0;
                parent[i] = i;
            }
        }

        int findParent(int v) {
            if (parent[v] != v) {
                return findParent(parent[v]);
            }
            return parent[v];
        }

        void union(int x, int y) {
            int xp = findParent(x);
            int yp = findParent(y);

            if (rank[xp] > rank[yp]) {
                parent[yp] = xp;
            } else if (rank[yp] > rank[xp]) {
                parent[xp] = yp;
            } else {
                parent[yp] = xp;
                rank[xp]++;
            }
        }
    }

    public int minCostConnectPoints(int[][] points) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                edges.add(new Edge(i, j, Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1])));
            }
        }

        Collections.sort(edges);
        int mc = 0;
        DisjointSet ds = new DisjointSet(points.length);
        for (Edge e: edges) {
            if (ds.findParent(e.s) != ds.findParent(e.d)) {
                ds.union(e.s, e.d);
                mc += e.w;
            }
        }

        return mc;
    }
}