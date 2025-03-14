class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        int num = 0;
        int sign = 1;

        for (char c: s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                res += sign * num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                res += sign * num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += num * sign;
                num = 0;
                res *= st.pop();
                res += st.pop();
            }
        }

        return res + sign * num;
    }
}