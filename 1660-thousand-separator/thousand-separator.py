class Solution:
    def thousandSeparator(self, n: int) -> str:
        n = str(n)
        if len(n) <= 3:
            return n
        else:
            return f"{self.thousandSeparator(n[:-3])}.{n[-3:]}"
