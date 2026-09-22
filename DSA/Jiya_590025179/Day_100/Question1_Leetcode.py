class Solution:
    def minEatingSpeed(self, piles: list[int], h: int) -> int:
        low=1
        high=max(piles)
        while low<=high:
            k=(low+high)//2
            hours=0
            for pile in piles:
                hours=hours+(pile+k-1)//k
            if hours<=h:
                high=k-1
            else:
                low=k+1
        return low
