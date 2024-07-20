class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for ind in range(len(nums)):
            if (target - nums[ind]) in nums and nums.index(target - nums[ind]) != ind:
                return [nums.index(target - nums[ind]), ind]
    