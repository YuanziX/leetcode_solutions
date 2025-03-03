class Solution {
    public int fib(int n) {
        System.gc();
        if (n < 2) return n;
        int a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            int temp = a;
            a = b;
            b += temp;
        }

        return a;
    }
}