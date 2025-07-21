class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();

        char ch = 'a'; int count = 0;

        for (char c: s.toCharArray()) {
            if (ch == c) {
                count++;
                if (count > 2) {
                    continue;
                }
            } else {
                ch = c;
                count = 1; 
            }
            sb.append(c);
        }

        return sb.toString();
    }
}