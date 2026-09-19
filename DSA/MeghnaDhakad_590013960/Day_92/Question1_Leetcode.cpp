class Solution {
public:
    int climbStairs(int n) {
        // Base cases: 1 way to reach step 1, 2 ways to reach step 2
        if (n <= 2) return n;
        
        int prev2 = 1; // Ways to reach (n-2)
        int prev1 = 2; // Ways to reach (n-1)
        
        for (int i = 3; i <= n; ++i) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        
        return prev1;
    }
};