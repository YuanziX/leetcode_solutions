class Solution:
    def reverseWords(self, s: str) -> str:
        return ' '.join(re.sub(r"\s+", " ", s).strip().split(' ')[::-1])