class Solution:
    def intToRoman(self, num: int) -> str:
        roman = {
            "M" : 1000,
            "CM" : 900,
            "D"  : 500,
            "CD" : 400,
            "C" : 100,
            "XC" : 90,
            "L" : 50,
            "XL" : 40,
            "X" : 10,
            "IX" : 9,
            "V" : 5,
            "IV" : 4,
            "I" : 1 
        }
        
        n = num
        outp = ""
        for key, value in roman.items():
            if n >= value:
                outp += key*(n//value)
                n %= value
        
        return(outp)