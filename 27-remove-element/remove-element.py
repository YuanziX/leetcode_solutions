class Solution:
    def removeElement(self, nums, val):
        while True:
            if val in nums:
                nums.remove(val)
            else:
                break
        return len(nums)