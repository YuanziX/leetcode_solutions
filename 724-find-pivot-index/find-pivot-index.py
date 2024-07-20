class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        lsum, rsum = 0, sum(nums)

        for i, val in enumerate(nums):
            rsum -= val
            if lsum == rsum:
                return i
            lsum += val
        return -1