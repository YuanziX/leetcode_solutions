class Solution {
    public int longestValidParentheses(String s) {
        int[] arr = new int[s.length()];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else if (!st.isEmpty()) {
                arr[st.pop()] = 1;
                arr[i] = 1;
            }
        }

        int max = Integer.MIN_VALUE;
        int start = 0;
        int end;

        for (end = 0; end < arr.length; end++) {
            if (arr[end] == 0) {
                max = Math.max(max, end - start);
                start = end + 1;
            }
        }
        max = Math.max(max, end - start);

        return max;
    }
}