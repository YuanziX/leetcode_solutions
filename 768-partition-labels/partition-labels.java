class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> start = new HashMap<>();
        Map<Character, Integer> end = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!start.containsKey(c)) {
                start.put(c, i);
            }
            end.put(c, i);
        }

        List<int[]> intervals = new ArrayList<>();
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }
        for (char c : uniqueChars) {
            intervals.add(new int[] { start.get(c), end.get(c) });
        }
        Collections.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals.get(0);
        merged.add(prev);

        for (int i = 1; i < intervals.size(); i++) {
            int[] curr = intervals.get(i);

            if (curr[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                merged.add(curr);
                prev = curr;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int[] i : merged) {
            res.add(i[1] - i[0] + 1);
        }

        return res;
    }
}