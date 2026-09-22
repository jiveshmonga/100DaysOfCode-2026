class Solution {
    public int climbStairs(int n) {
        int a = 1;
        if (n == 1) {
            return a;
        }
        int b = 2;

        for (int i = 3 ; i <=n ; i++ ) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;

        
    }
}