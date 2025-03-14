class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] ls = new int[n];
        int[] rs = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i > -1; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                rs[i] = st.peek() - i;
            } else {
                rs[i] = n - i;
            }

            st.push(i);
        }

        while (!st.isEmpty()) {
            st.pop();
        }

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            if (!st.isEmpty()) {
                ls[i] = i - st.peek();
            } else {
                ls[i] = i + 1;
            }

            st.push(i);
        }

        int maxHeight = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxHeight = Math.max(maxHeight, heights[i] * (ls[i] + rs[i] - 1));
        }

        return maxHeight;
    }
}