#include <vector>

using namespace std;

class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> ans(n + 1, 0);
        
        for (int i = 1; i <= n; ++i) {
            // ans[i >> 1] gets the bits of i / 2
            // (i & 1) adds 1 if the current number is odd
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }
};