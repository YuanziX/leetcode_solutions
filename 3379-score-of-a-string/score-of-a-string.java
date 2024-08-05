class Solution {
    public int scoreOfString(String s) {
        int j = 0;
        int sum = 0;

        for (int i = 1; i < s.length(); i++) {
            sum += Math.abs(Character.getNumericValue(s.charAt(j)) - Character.getNumericValue(s.charAt(i)));
            j++;
        }

        return sum;
    }
}