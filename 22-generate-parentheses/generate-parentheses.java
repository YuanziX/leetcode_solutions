class Solution {
    private void recursive(int n, StringBuilder dat, int numOpen, int numClosed, List<String> res) {
        if (dat.length() == 2*n) {
            res.add(dat.toString());
            return;
        }

        if (numOpen < n) {
            recursive(n, new StringBuilder(dat).append("("), numOpen+1, numClosed, res);
        }

        if (numOpen > numClosed) {
            recursive(n, new StringBuilder(dat).append(")"), numOpen, numClosed+1, res);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recursive(n, new StringBuilder("("), 1, 0, res);
        return res;
    }
}