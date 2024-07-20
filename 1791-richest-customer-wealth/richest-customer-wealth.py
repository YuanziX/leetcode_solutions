class Solution:
    def maximumWealth(self, accounts: List[List[int]]) -> int:
        max = 0

        for cust in accounts:
            if sum(cust) > max:
                max = sum(cust)
        return max