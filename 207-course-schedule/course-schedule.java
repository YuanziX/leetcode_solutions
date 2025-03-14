class Solution {
    public boolean canFinish(int c, int[][] prereq) {
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

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int i: g.get(node)) {
                indeg[i]--;
                if (indeg[i] == 0) {
                    q.add(i);
                }
            }
        }

        for (int i = 0; i < c; i++) {
            if (indeg[i] != 0) {
                return false;
            }
        }

        return true;
    }
}