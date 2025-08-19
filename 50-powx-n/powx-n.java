class Solution {
    public double myPow(double x, int n) {
        double res = 1;

        long nn = n;
        if (nn < 0) nn *= -1;

        while (nn > 0) {
            if (nn % 2 == 1) {
                res *= x;
                nn--;
            } else {
                x *= x;
                nn /= 2;
            }
        }

        if (n < 0) return 1.0 / res;
        return res;
    }
}