class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        helper(new StringBuilder(), n, 0, 0, res);
        return res;
    }

    private void helper(StringBuilder cur, int n, int l, int r, List<String> res) {
        if (cur.length() == n * 2) {
            res.add(cur.toString());
            return;
        }

        if (l < n) {
            cur.append('(');
            helper(cur, n, l + 1, r, res);
            cur.setLength(cur.length() - 1);
        }

        if (r < l) {
            cur.append(')');
            helper(cur, n, l, r + 1, res);
            cur.setLength(cur.length() - 1);
        }
    }
}