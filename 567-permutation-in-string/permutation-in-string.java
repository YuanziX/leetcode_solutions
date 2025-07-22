class Solution {
    public boolean checkInclusion(String s2, String s1) {
        int l1 = s1.length(), l2 = s2.length();
        if (l2 > l1) return false;

        int[] windowCount = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < l2; i++) {
            s2Count[s2.charAt(i) - 'a']++;
            windowCount[s1.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (s2Count[i] == windowCount[i]) matches++;
        }

        for (int r = l2; r < l1; r++) {
            if (matches == 26) return true;

            int inIdx = s1.charAt(r) - 'a';
            int outIdx = s1.charAt(r - l2) - 'a';

            windowCount[inIdx]++;
            if (windowCount[inIdx] == s2Count[inIdx]) {
                matches++;
            } else if (windowCount[inIdx] - 1 == s2Count[inIdx]) {
                matches--;
            }

            windowCount[outIdx]--;
            if (windowCount[outIdx] == s2Count[outIdx]) {
                matches++;
            } else if (windowCount[outIdx] + 1 == s2Count[outIdx]) {
                matches--;
            }
        }

        return matches == 26;
    }
}
