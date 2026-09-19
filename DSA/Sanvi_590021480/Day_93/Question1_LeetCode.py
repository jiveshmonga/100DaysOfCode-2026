class Solution:
    def countBits(self, n: int) -> List[int]:
        ans=[]
        for i in range(0,n+1):
            a=bin(i).count('1')
            ans.append(a)
        return ans
        
