class Solution:
    def mySqrt(self, x: int) -> int:
        for i in range(x+1):
            ii = i*i
            if ii == x:
                return i
            elif ii > x:
                return i-1