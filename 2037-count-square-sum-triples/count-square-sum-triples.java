class Solution {
    public int countTriples(int n) {
        // Map perfectSquare -> sqrt(perfectSquare)
        HashMap<Integer, Integer> sqrtMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            sqrtMap.put(i * i, i);
        }

        int count = 0;

        for (int a = 1; a <= n; a++) {
            int a2 = a * a;
            for (int b = 1; b <= n; b++) {
                int c2 = a2 + b * b;

                // Check if c² exists in the map
                Integer root = sqrtMap.get(c2);
                if (root != null && root <= n) {
                    count++;
                }
            }
        }
        return count;
    }
}
