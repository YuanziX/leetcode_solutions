class Solution:
    def isPalindrome(self, x: int) -> bool:
        x = str(x); rev = x[::-1]
        return True if rev == x else False
