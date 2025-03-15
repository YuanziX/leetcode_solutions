class Solution {
    public boolean canFinish(int c, int[][] prereq) {
        List<List<Integer>> g = new ArrayList<>();

        for (int i = 0; i < c; i++) {
            g.add(new ArrayList<>());
        }

        int[] indeg = new int[c];
        for (int[] rel: prereq) {
            g.get(rel[1]).add(rel[0]);
            indeg[rel[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < c; i++) {
            if (indeg[i] == 0) q.add(i);
        }

        int ptr = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            ptr++;

            for (int i: g.get(node)) {
                indeg[i]--;
                if (indeg[i] == 0) {
                    q.add(i);
                }
            }
        }

        return ptr == c;
    }
}