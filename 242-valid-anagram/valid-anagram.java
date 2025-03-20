class Solution {
    public boolean isAnagram(String s, String t) {
        PriorityQueue<Character> pq1 = new PriorityQueue<>();
        PriorityQueue<Character> pq2 = new PriorityQueue<>();

        for (char c: s.toCharArray()) {
            pq1.add(c);
        }
        for (char c: t.toCharArray()) {
            pq2.add(c);
        }

        while (!pq1.isEmpty() && !pq2.isEmpty() && pq1.peek().equals(pq2.peek())) {
            pq1.poll();
            pq2.poll();
        }
        return pq1.size() == 0 && 0 == pq2.size();
    }
}