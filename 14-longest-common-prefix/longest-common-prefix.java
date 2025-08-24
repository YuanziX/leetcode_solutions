class Solution {
    public String longestCommonPrefix(String[] strs) {
        int prefix = Integer.MAX_VALUE;
        String shortest = "";

        for (String s: strs) {
            if (s.length() < prefix) {
                prefix = s.length();
                shortest = s;
            }
        }

        for (String s: strs) {
            for (int i = 0; i < prefix; i++) {
                if (s.charAt(i) != shortest.charAt(i)) {
                    prefix = i;
                    break;
                }
            }
        }

        return shortest.substring(0, prefix);
    }
}