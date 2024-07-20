class Solution:
    def reverse(self, x: int) -> int:
        y = abs(x); rev = 0
        while y != 0:
            rev = rev*10 + (y%10)
            y //= 10
        return 0 if (rev < -2**31 or rev >= 2**31) else (-rev if x < 0 else rev)