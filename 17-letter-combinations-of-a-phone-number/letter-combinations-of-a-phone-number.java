class Solution {
    String[] dict = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.equals("")) return res;

        helper(new StringBuilder(), 0, digits, res);

        return res;
    }

    private void helper(StringBuilder sb, int ind, String digits, List<String> res) {
        if (digits.length() == ind) {
            res.add(sb.toString());
            return;
        }

        for (char c: dict[digits.charAt(ind) - '0'].toCharArray()) {
            sb.append(c);
            helper(sb, ind + 1, digits, res);
            sb.setLength(sb.length() - 1);
        }
    }
}