class Solution:
    def isSubsequence(self, s: str, t: str) -> bool:
        if not len(s):return True
        schar = 0;found = 0
        for i in t:
            if schar >= len(s):break
            if i == s[schar]:
                schar += 1; found += 1
        return found == len(s)