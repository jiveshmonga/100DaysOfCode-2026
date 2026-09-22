#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int maxSignalHappiness(int T, const vector<int>& duration, const vector<int>& happiness) {
    int n = duration.size();
    
    // dp[w] stores the max happiness obtainable with exactly 'w' time
    vector<int> dp(T + 1, 0);
    
    // Process each relay/activity
    for (int i = 0; i < n; ++i) {
        // Traverse backwards to ensure each item is only used once per combination
        for (int w = T; w >= duration[i]; --w) {
            dp[w] = max(dp[w], dp[w - duration[i]] + happiness[i]);
        }
    }
    
    return dp[T];
}

int main() {
    int T = 7;
    vector<int> duration = {2, 3, 4, 5};
    vector<int> happiness = {4, 5, 7, 8};
    
    cout << "Output: " << maxSignalHappiness(T, duration, happiness) << "\n";
    // Expected Output: 12
    
    return 0;
}