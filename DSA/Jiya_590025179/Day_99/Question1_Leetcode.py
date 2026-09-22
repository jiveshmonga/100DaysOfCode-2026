class Solution:
    def firstMissingPositive(self, nums: list[int]) -> int:
        j=1
        nums=set(nums)
        while j in nums:
            j=j+1
        return j       
