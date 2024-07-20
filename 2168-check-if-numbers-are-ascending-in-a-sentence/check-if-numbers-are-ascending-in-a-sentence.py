class Solution:
    def areNumbersAscending(self, s: str) -> bool:
        nums = re.findall("[+\-]?\d+", s)
        check = int(nums[0])
        for num in nums[1:]:
            if int(num) <= check:
                return False
            else:
                check = int(num)
        else:
            return True