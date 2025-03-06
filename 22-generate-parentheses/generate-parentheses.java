class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n, new StringBuilder(), 0, 0, res);
        return res;
    }

    public void helper(int n, StringBuilder curr, int l, int r, List<String> res) {
        if (l + r == 2 * n) {
            res.add(curr.toString());
            return;
        }

        if (l < n) {
            curr.append('(');
            helper(n, curr, l + 1, r, res);
            curr.setLength(curr.length() - 1);
        }

        if (r < l) {
        curr.append(')');
            helper(n, curr, l, r + 1, res);
            curr.setLength(curr.length() - 1);
        }
    }
}