class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        helper(s, 0, 0, 0, new ArrayList<>(), res);
        return res;
    }

    void helper(String s, int start, int i, int len, List<String> sub, List<List<String>> res) {
        if (i == s.length()) {
            if (len == i)
                res.add(new ArrayList<>(sub));

            return;
        }

        String substring = s.substring(start, i + 1);
        if (isPalindrome(substring)) {
            sub.add(substring);
            helper(s, i + 1, i + 1, len + i - start + 1, sub, res);
            sub.remove(sub.size() - 1);
        }

        helper(s, start, i + 1, len, sub, res);
    } 

    boolean isPalindrome(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }
}