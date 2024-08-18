class Solution {
    public String largestOddNumber(String num) {
        for (int r = num.length() - 1; r >= 0; r--) {
            char c = num.charAt(r);
            if (c == '1' || c == '3' || c == '5' || c == '7' || c == '9') {
                return num.substring(0, r + 1);
            }
        }
        return "";
    }
}
