class Solution {
    public String fractionAddition(String expression) {
        int numerator = 0, denominator = 1;

        int i = 0, n = expression.length();
        while (i < n) {
            int sign = 1;
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
                sign = expression.charAt(i) == '-' ? -1 : 1;
                i++;
            }

            int numStart = i;
            while (i < n && Character.isDigit(expression.charAt(i))) i++;
            int num = Integer.parseInt(expression.substring(numStart, i));

            i++;

            int denomStart = i;
            while (i < n && Character.isDigit(expression.charAt(i))) i++;
            int denom = Integer.parseInt(expression.substring(denomStart, i));

            numerator = numerator * denom + sign * num * denominator;
            denominator *= denom;

            int gcd = gcd(Math.abs(numerator), denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
