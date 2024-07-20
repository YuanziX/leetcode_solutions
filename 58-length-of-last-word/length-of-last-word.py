class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        n = 0
        for i in s[::-1]:
            if i != " ":
                n += 1
            elif i == " " and n > 0:
                return n
        else:
            return n