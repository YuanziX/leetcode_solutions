class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            while (!st.isEmpty() && asteroid < 0 && st.peek() > 0) {
                int top = st.peek();
                if (top < -asteroid) {
                    st.pop();
                } else if (top == -asteroid) {
                    st.pop();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                st.push(asteroid);
            }
        }

        int[] res = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }
        return res;
    }
}
