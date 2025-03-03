class Solution {
    public String mergeAlternately(String word1, String word2) {
        int min = Math.min(word1.length(), word2.length());
        int ptr1 = min;
        int ptr2 = min;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < min; i++) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
        }

        while (ptr1 < word1.length()) {
            result.append(word1.charAt(ptr1));
            ptr1++;
        }

        while (ptr2 < word2.length()) {
            result.append(word2.charAt(ptr2));
            ptr2++;
        }

        return result.toString();
    }
}