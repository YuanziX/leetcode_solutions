class Solution {
    public int minAddToMakeValid(String s) {
        int close = 0, open = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') open++;
            else if (open > 0) open--;
            else close++;
        }

        return close + open;
    }
}