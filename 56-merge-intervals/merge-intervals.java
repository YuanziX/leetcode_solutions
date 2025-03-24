class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        int ptr = 0;

        for (int i = 1; i < n; i++) {
            int prevEnd = merged.get(ptr)[1];
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start <= prevEnd) {
                merged.get(ptr)[1] = Math.max(prevEnd, end);
            } else {
                merged.add(intervals[i]);
                ++ptr;
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}