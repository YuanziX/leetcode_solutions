class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int number = 0;
        int res = 0;
        int sign = 1;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = 10 * number + (c - '0');
            } else if (c == '+') {
                res = res + sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                res = res + sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                st.push(res);
                st.push(sign);
                sign = 1;
                res = 0;
            } else if (c == ')') {
                res += sign * number;
                number = 0;
                res *= st.pop();
                res += st.pop();
            }
        }

        return res + sign * number;
    }
}