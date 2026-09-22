#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int maxHappiness(int T, const vector<int>& duration, const vector<int>& happiness) {
    int n = duration.size();
    
    // dp[w] stores the max happiness obtainable with exactly 'w' time
    vector<int> dp(T + 1, 0);
    
    // Process each activity
    for (int i = 0; i < n; ++i) {
        // Traverse backwards to avoid reusing the same activity in the same combination
        for (int w = T; w >= duration[i]; --w) {
            // Choice: keep current max, or take the activity + the best we could do with remaining time
            dp[w] = max(dp[w], dp[w - duration[i]] + happiness[i]);
        }
    }
    
    // The answer for the maximum available time
    return dp[T];
}

int main() {
    int T = 7;
    vector<int> duration = {2, 3, 4, 5};
    vector<int> happiness = {4, 5, 7, 8};
    
    cout << "Output: " << maxHappiness(T, duration, happiness) << "\n";
    // Expected Output: 12 (Combining activities taking 3 and 4 hours gives 5 + 7 = 12 happiness)
    
    return 0;
}