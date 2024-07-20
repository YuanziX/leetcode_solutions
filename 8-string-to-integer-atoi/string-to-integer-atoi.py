class Solution:
    def myAtoi(self, s: str) -> int:
        parsed = re.match(r"\s*[+\-]?\d+", s)
        num = int(parsed.group()) if parsed else 0
        return -2**31 if num < -2**31 else (2**31-1 if num >= 2**31 else num)