class Solution {
public:
    int tribonacci(int n) {
        // Base cases
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        
        // Compute from the 3rd index up to n
        for (int i = 3; i <= n; ++i) {
            int current = t0 + t1 + t2;
            
            // Slide the window forward
            t0 = t1;
            t1 = t2;
            t2 = current;
        }
        
        return t2;
    }
};