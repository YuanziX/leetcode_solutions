class Solution {
    String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;

        helper(digits, new StringBuilder(), 0, res);
        return res;
    }

    public void helper(String digits, StringBuilder curr, int pos, List<String> res) {
        if (pos == digits.length()) {
            res.add(curr.toString());
            return;
        }

        String combo = map[Character.getNumericValue(digits.charAt(pos))];

        for (char c: combo.toCharArray()) {
            curr.append(c);
            helper(digits, curr, pos + 1, res);
            curr.setLength(curr.length() - 1);
        }
    }
}