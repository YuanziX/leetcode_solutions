class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> st = new Stack<>();

        for (char c: s.toCharArray()) {
            if (isOpening(c)) {
                st.push(c);
            } else if (st.isEmpty() || st.pop() != getOpening(c)) {
                return false;
            }
        }

        return st.isEmpty();
    }

    public boolean isOpening(char c) {
        if (c == '(' || c == '[' || c == '{')
            return true;
        return false;
    }

    public char getOpening(char c) {
        if (c == ')') {
            return '(';
        } else if (c == ']') {
            return '[';
        } else if (c == '}') {
            return '{';
        }

        return '9';
    }
}