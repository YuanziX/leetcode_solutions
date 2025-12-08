class Solution {
    public int countTriples(int n) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(i * i);
        }

        int c = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (set.contains(i * i + j * j)) {
                    c++;
                }
            }
        }
        return c;
    }

}