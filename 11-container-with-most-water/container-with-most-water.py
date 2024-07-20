class Solution:
    def maxArea(self, height: List[int]) -> int:
        i = 0
        e = len(height)-1
        maxArea = 0
        while i < e:
            area = (e - i) * min(height[i], height[e])
            maxArea = max(area,maxArea)
            if height[i]<height[e]:
                i += 1
            else:
                e -= 1
        return maxArea