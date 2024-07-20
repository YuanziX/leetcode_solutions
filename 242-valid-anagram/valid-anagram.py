class Solution:
    def isAnagram(self, s, t):
        if len(s) != len(t):
            return False
        for ch in set(s):
            if s.count(ch) != t.count(ch):
                return False
        return True
