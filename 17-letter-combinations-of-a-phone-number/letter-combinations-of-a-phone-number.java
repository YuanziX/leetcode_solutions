class Solution {
    Map<Integer, char[]> map = new HashMap<>() {{
        put(2, new char[]{'a', 'b', 'c'});
        put(3, new char[]{'d', 'e', 'f'});
        put(4, new char[]{'g', 'h', 'i'});
        put(5, new char[]{'j', 'k', 'l'});
        put(6, new char[]{'m', 'n', 'o'});
        put(7, new char[]{'p', 'q', 'r', 's'});
        put(8, new char[]{'t', 'u', 'v'});
        put(9, new char[]{'w', 'x', 'y', 'z'});
    }};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;

        helper(digits, "", 0, res);
        return res;
    }

    public void helper(String digits, String curr, int pos, List<String> res) {
        if (pos == digits.length()) {
            res.add(curr);
            return;
        }

        char[] combo = map.get(Character.getNumericValue(digits.charAt(pos)));
        if (combo == null) return;

        for (char c: combo) {
            helper(digits, curr + c, pos + 1, res);
        }
    }
}