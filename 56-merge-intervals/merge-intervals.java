class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        int ptr = 0;

        for (int i = 1; i < n; i++) {
            int[] prev = merged.get(ptr);
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start <= prev[1]) {
                prev[1] = Math.max(prev[1], end);
            } else {
                merged.add(intervals[i]);
                ++ptr;
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}