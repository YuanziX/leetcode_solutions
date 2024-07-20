class Solution:
    def divide(self, dividend: int, divisor: int, quotient=0) -> int:
        pos = (dividend < 0) is (divisor < 0)
        dividend, divisor = abs(dividend), abs(divisor)
        while dividend >= divisor:
            dec = divisor
            count = 1
            while dividend >= dec:
                dividend -= dec
                quotient += count
                count += count
                dec += dec
        quotient = quotient if pos else -quotient
        return -2**31 if quotient < -2**31 else (2**31-1 if quotient >= 2**31 else quotient)