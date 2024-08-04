class Solution {
    public int maxPower(String s) {
        int max = 0;
        int tempMax = 0;
        char ch = 'A';

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                tempMax++;
            } else {
                ch = s.charAt(i);
                max = Math.max(max, tempMax);
                tempMax = 1;
            }
        }

        return Math.max(max, tempMax);
    }
}