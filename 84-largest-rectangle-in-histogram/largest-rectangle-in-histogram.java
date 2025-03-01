class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] pse = new int[heights.length];
        int[] nse = new int[heights.length];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            while (!st.empty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.empty()) {
                pse[i] = i + 1;
            } else {
                pse[i] = i - st.peek();
            }

            st.push(i);
        }

        st.clear();

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                nse[i] = heights.length - i;
            } else {
                nse[i] = st.peek() - i;
            }
            st.push(i);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < heights.length; i++) {
            int calc = heights[i] * (nse[i] + pse[i] - 1);
            if (calc > max) {
                max = calc;
            }
        }

        return max;
    }
}