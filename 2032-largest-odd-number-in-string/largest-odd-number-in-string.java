class Solution {
    public String largestOddNumber(String num) {
        int r = num.length() - 1;

        while (r >= 0) {
            if (Character.getNumericValue(num.charAt(r)) % 2 == 0) {
                r--;
            } else {
                return num.substring(0, r + 1);
            }
        }

        return "";
    }
}