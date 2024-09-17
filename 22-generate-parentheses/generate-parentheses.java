class Solution {
    private void recursive(int n, String dat, int numOpen, int numClosed, List<String> res) {
        if (dat.length() == 2*n) {
            res.add(dat);
            return;
        }

        if (numOpen < n) {
            recursive(n, dat + "(", numOpen+1, numClosed, res);
        }

        if (numOpen > numClosed) {
            recursive(n, dat + ")", numOpen, numClosed+1, res);
        }
    }

    public void recurse(int n, List<String> res) {
        recursive(n, "(", 1, 0, res);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recurse(n, res);
        return res;
    }
}