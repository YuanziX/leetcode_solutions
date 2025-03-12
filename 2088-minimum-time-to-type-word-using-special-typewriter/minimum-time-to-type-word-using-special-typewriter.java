class Solution {
    public int minTimeToType(String word) {
        int time = 0;
        int pos = 0;
        for (char c : word.toCharArray()) {
            time += Math.min(Math.abs(c - 'a' - pos), 26 - Math.abs(c - 'a' - pos)) + 1;
            pos = c - 'a';
        }

        return time;
    }
}