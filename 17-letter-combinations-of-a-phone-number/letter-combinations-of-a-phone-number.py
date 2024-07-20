class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        letterMap = {
            "2" : "abc",
            "3" : "def",
            "4" : "ghi",
            "5" : "jkl",
            "6" : "mno",
            "7" : "pqrs",
            "8" : "tuv",
            "9" : "wxyz"
            }

        chars = [letterMap[d] for d in digits]
        return [''.join(i) for i in list(itertools.product(*chars))] if digits else []