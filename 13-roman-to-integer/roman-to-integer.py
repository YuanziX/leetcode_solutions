class Solution:
    def romanToInt(self, s: str) -> int:
        roman = {
            "M" : 1000,
            "D" : 500,
            "C" : 100,
            "L" : 50,
            "X" : 10,
            "V" : 5,
            "I" : 1
        }
        num = 0
        length = len(s)
        for char in range(length):
            if (char == length - 1) or (roman[s[char]] >= roman[s[char+1]]):
                num += roman[s[char]]
            else:
                num -= roman[s[char]]
    
        return num