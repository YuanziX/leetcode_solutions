class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        dt = defaultdict(int)

        for i in nums:
            dt[i] += 1
        
        n = len(nums) // 3

        res = []

        for k, v in dt.items():
            if v > n:
                res.append(k)
        
        return res