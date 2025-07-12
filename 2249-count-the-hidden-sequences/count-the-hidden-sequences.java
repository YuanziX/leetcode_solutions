class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0, max = 0, curr = 0;

        for (int diff : differences) {
            curr += diff;
            min = Math.min(min, curr);
            max = Math.max(max, curr);
        }

        return (int)Math.max(0, (upper - lower) - (max - min) + 1);
    }
}
