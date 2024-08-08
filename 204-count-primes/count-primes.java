class Solution {
    public int countPrimes(int n) {
        int ans = 0;
        boolean[] isPrime = new boolean[n+1];
        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                ans++;
                for (int j = 2; j < n; j++) {
                    if (j * i > n) {
                        break;
                    }
                    isPrime[i * j] = false;
                }
            }
        }
        return ans;
    }
}