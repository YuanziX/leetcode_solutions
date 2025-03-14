class Solution {
    public int[] findOrder(int c, int[][] prereq) {
        List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i < c; i++) {
            g.add(new ArrayList<>());
        }

        for (int[] rel: prereq) {
            g.get(rel[1]).add(rel[0]);
        }

        int[] indeg = new int[c];
        for (List<Integer> li: g) {
            for (int i: li) {
                indeg[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < c; i++) {
            if (indeg[i] == 0) q.add(i);
        }

        int[] topo = new int[c];
        int ptr = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            topo[ptr++] = node;

            for (int i: g.get(node)) {
                indeg[i]--;
                if (indeg[i] == 0) {
                    q.add(i);
                }
            }
        }

        return ptr == c ? topo : new int[] {};
    }
}