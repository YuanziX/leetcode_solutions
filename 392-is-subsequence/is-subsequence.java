class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int i = 0, j = 0;
        while (i < sc.length && j < tc.length) {
            if (sc[i] == tc[j]) {
                i++;
            }
            j++;
        }

        return i == sc.length;
    }
}