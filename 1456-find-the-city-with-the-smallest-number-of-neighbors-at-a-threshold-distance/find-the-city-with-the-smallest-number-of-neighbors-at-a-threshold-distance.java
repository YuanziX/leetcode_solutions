class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }

        for (int[] edge: edges) {
            distance[edge[0]][edge[1]] = edge[2];
            distance[edge[1]][edge[0]] = edge[2];
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][k] != Integer.MAX_VALUE && distance[j][k] != Integer.MAX_VALUE) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int index = 0;

        for (int j = 0; j < n; j++) {
            int[] city = distance[j];

            int local = 0;
            for (int i: city) {
                if (i <= distanceThreshold) local++;
            }

            if (local <= min) {
                min = local;
                index = Math.max(index, j);
            }
        }

        return index;
    }
}