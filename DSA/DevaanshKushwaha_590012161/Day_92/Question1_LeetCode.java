class Solution {
    public int climbStairs(int n) {
        // Base cases: 1 way to reach step 0 (do nothing) or step 1
        if (n <= 2) return n;

        int prev2 = 1; // ways to reach step (i-2), starts as ways(0)... 
                        // but we init at i=2 directly, so prev2 = ways(1)
        int prev1 = 2; // ways(2)

        for (int i = 3; i <= n; i++) {
            int curr = prev1 + prev2; // ways(i) = ways(i-1) + ways(i-2)
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
