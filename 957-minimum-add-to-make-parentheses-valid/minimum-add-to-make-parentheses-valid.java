class Solution {
    public int minAddToMakeValid(String s) {
        int close = 0, open = 0;

        for (char c: s.toCharArray()) {
            if (c == '(') open++;
            else if (open > 0) open--;
            else close++;
        }

        return close + open;
    }
}