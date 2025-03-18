class Solution {
    public String fractionAddition(String exp) {
        int numerator = 0, denominator = 1;
        char[] expression = exp.toCharArray();

        int i = 0, n = expression.length;
        while (i < n) {
            int sign = 1;
            if (expression[i] == '+' || expression[i] == '-') {
                sign = expression[i] == '-' ? -1 : 1;
                i++;
            }

            int numStart = i;
            while (i < n && Character.isDigit(expression[i])) i++;
            int num = Integer.parseInt(exp.substring(numStart, i));

            i++;

            int denomStart = i;
            while (i < n && Character.isDigit(expression[i])) i++;
            int denom = Integer.parseInt(exp.substring(denomStart, i));

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
