class Solution(object):
    def missingNumber(self, nums):
        n = len(nums)
        totalsum = n*(n+1)//2
        arraysum = sum(nums)

        return totalsum - arraysum