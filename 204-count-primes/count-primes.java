class Solution {
    public int countPrimes(int n) {
        int ans = 0;
        boolean[] isPrime = new boolean[5000000];
        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                ans++;
                for (int j = i + i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return ans;
    }
}