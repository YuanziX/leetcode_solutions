class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int tempOnes = 0;

        for (int i : nums) {
            if (i == 1) {
                tempOnes++;
            } else {
                if (maxOnes < tempOnes)
                    maxOnes = tempOnes;
                tempOnes = 0;
            }
        }

        return Math.max(maxOnes, tempOnes);
    }
}