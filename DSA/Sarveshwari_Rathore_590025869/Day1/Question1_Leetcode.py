class Solution(object):
    def missingNumber(self, nums):
        n = len(nums)
        arrsum = sum(nums)
        total = (n * (n + 1)) // 2
        return total - arrsum