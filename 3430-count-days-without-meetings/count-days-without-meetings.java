class Solution {
    public int countDays(int days, int[][] meetings) {
        int n = meetings.length;
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        merged.add(meetings[0]);
        int ptr = 0;

        for (int i = 1; i < n; i++) {
            int[] prev = merged.get(ptr);
            int start = meetings[i][0];
            int end = meetings[i][1];

            if (start <= prev[1]) {
                prev[1] = Math.max(prev[1], end);
            } else {
                merged.add(meetings[i]);
                ++ptr;
            }
        }

        int c = merged.get(0)[0] + days - merged.get(merged.size() - 1)[1] - 1;
        for (int i = 0; i < merged.size() - 1; i++) {
            c += merged.get(i + 1)[0] - merged.get(i)[1] - 1;
        }
        
        return c;
    }
}