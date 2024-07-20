numbers = {
    0: "Zero",
    1: "One",
    2: "Two",
    3: "Three",
    4: "Four",
    5: "Five",
    6: "Six",
    7: "Seven",
    8: "Eight",
    9: "Nine",
    10: "Ten",
    11: "Eleven",
    12: "Twelve",
    13: "Thirteen",
    14: "Fourteen",
    15: "Fifteen",
    16: "Sixteen",
    17: "Seventeen",
    18: "Eighteen",
    19: "Nineteen",
    20: "Twenty",
    30: "Thirty",
    40: "Forty",
    50: "Fifty",
    60: "Sixty",
    70: "Seventy",
    80: "Eighty",
    90: "Ninety"
}

powers_of_10 = {
    "Thousand": 10**3,
    "Million": 10**6,
    "Billion": 10**9,
    "Trillion": 10**12,
    "Quadrillion": 10**15,
    "Quintillion": 10**18,
    "Sextillion": 10**21,
    "Septillion": 10**24,
    "Octillion": 10**27,
    "Nonillion": 10**30
}

class Solution:
    def numberToWords(self, num: int, start=True) -> str:
        if num == 0 and start:
            return (numbers[num]).strip()
        if num < 10:
            return (numbers[num]).strip() if num != 0 else ""
        elif num < 100:
            return (numbers.get(num, numbers[num - num%10] + " " + self.numberToWords(num % 10, False))).strip()
        elif num < 1000:
            return (numbers[num // 100].rstrip() + " Hundred " + (self.numberToWords(num % 100, False) if num % 100 != 0 else "").lstrip()).strip()
        else:
            for name, value in powers_of_10.items():
                if num < value*10**3:
                    return (self.numberToWords(num // value, False).rstrip() + f" {name} " + self.numberToWords(num % value, False).lstrip()).strip()