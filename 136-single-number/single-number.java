import java.util.Arrays;
class Solution {
    public static int singleNumber(int[] nums) {
        int num = 0;

        for (int n: nums) {
            num = n ^ num;
        }

        return num;
    }
}