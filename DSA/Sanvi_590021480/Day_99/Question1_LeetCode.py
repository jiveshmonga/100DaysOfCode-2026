class Solution:
    def firstMissingPositive(self, nums: list[int]) -> int:
        maxno=max(max(nums),0)
        setno=set(nums)
        for i in range(1,maxno+2):
            if i not in setno:
                return i
        
