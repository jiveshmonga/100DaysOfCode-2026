#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

int minCost(int n, vector<int>& cuts) {
    // Step 1 & 2: Add the stick ends and sort
    cuts.push_back(0);
    cuts.push_back(n);
    sort(cuts.begin(), cuts.end());
    
    int m = cuts.size();
    // dp[i][j] will store the min cost to cut the segment between cuts[i] and cuts[j]
    vector<vector<int>> dp(m, vector<int>(m, 0));
    
    // Step 3: Iterate over the length of the intervals we are evaluating
    // len is the number of cut points we are spanning (start at 2, meaning 0 cuts between)
    for (int len = 2; len < m; ++len) {
        for (int i = 0; i < m - len; ++i) {
            int j = i + len;
            dp[i][j] = INT_MAX;
            
            // Step 4: Try every possible cut k between i and j
            for (int k = i + 1; k < j; ++k) {
                int current_cost = cuts[j] - cuts[i] + dp[i][k] + dp[k][j];
                dp[i][j] = min(dp[i][j], current_cost);
            }
        }
    }
    
    // The answer is the min cost to evaluate from the very first point (0) 
    // to the very last point (n).
    return dp[0][m - 1];
}

int main() {
    int n = 7;
    vector<int> cuts = {1, 3, 4, 5};
    
    cout << "Output: " << minCost(n, cuts) << "\n";
    // Expected Output: 16
    
    return 0;
}