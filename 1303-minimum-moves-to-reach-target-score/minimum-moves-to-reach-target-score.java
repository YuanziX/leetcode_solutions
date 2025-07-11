class Solution {
    public int minMoves(int target, int maxDoubles) {
        int moves = 0;

        while (target != 1) {
            if (maxDoubles > 0) {
                if ((target >> 1) >= 1 && (target & 1) == 0) {
                    target >>= 1;
                    maxDoubles--;
                } else {
                    target--;
                }
            } else {
                moves += target - 1;
                break;
            }
            moves++;
        }

        return moves;
    }
}