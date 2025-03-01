class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int[] res = new int[temp.length];
        Stack<Integer> st = new Stack<>();

        for (int i = temp.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && temp[st.peek()] <= temp[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                res[i] = 0;
            } else {
                res[i] = st.peek() - i;
            }
            st.push(i);
        }

        return res;
    }
}