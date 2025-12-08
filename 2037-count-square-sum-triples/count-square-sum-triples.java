class Solution {
    public int countTriples(int n) {
        int c = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                int c2 = a * a + b * b;
                int cRoot = (int)Math.sqrt(c2);
                if (cRoot <= n && cRoot * cRoot == c2) c++;
            }
        }
        return c;
    }
}
