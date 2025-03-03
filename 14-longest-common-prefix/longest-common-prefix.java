class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int index = 0;
        int ptr1 = 0, ptr2 = 0;

        while (ptr1 < strs[0].length() && ptr2 < strs[strs.length - 1].length()) {
            if (strs[0].charAt(index) != strs[strs.length - 1].charAt(index)) {
                return strs[0].substring(0, index);
            }
            ptr1++;
            ptr2++;
            index++;
        }

        return strs[0].substring(0, index);
    }
}