class Solution {
    public int numberOfSteps(int num) {
        if (num == 0) return 0;

        int steps = 0;

        while (num > 0) {
            if ((num & 1) == 1) steps++;
            num >>= 1;
            steps++;
        }

        return steps - 1;
    }
}