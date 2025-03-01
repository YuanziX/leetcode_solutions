class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> st = new Stack<>();

        for (char c: s.toCharArray()) {
            if (isOpening(c)) {
                st.push(c);
            } else {
                if (!st.isEmpty() && st.peek() == getOpening(c)) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }

        if (st.isEmpty()) {
            return true;
        }
        return false;
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