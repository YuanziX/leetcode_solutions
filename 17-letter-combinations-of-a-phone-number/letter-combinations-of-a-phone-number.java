class Solution {
    String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

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

        String combo = map[Character.getNumericValue(digits.charAt(pos))];

        for (char c: combo.toCharArray()) {
            helper(digits, curr + c, pos + 1, res);
        }
    }
}