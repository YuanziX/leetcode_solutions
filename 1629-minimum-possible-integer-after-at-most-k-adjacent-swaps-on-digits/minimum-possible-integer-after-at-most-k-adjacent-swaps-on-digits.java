class Solution {
    public String minInteger(String num, int k) {
        char[] ca = num.toCharArray();
        int n = ca.length;

        for (int i = 0; i < n && k > 0; i++) {
            int pos = i;
            for (int j = i + 1; j < n && j - i <= k; j++) {
                if (ca[j] < ca[pos]) pos = j;
            }

            char c = ca[pos];
            for (int j = pos; j > i; j--) ca[j] = ca[j - 1];
            ca[i] = c;

            k -= pos - i;
        }
        return new String(ca);
    }
}
