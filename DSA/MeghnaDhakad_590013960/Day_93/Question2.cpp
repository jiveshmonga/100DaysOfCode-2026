#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int strangePrinter(string s) {
    if (s.empty()) return 0;
    
    // Optimize by removing consecutive duplicates
    string unique_s = "";
    for (char c : s) {
        if (unique_s.empty() || unique_s.back() != c) {
            unique_s += c;
        }
    }
    
    int n = unique_s.length();
    // dp[i][j] represents the minimum turns to print unique_s[i...j]
    vector<vector<int>> dp(n, vector<int>(n, 0));
    
    // Build the DP table from the bottom up (smaller intervals first)
    for (int i = n - 1; i >= 0; --i) {
        dp[i][i] = 1; // Single character takes 1 turn
        
        for (int j = i + 1; j < n; ++j) {
            // Worst case: Print the previous substring, then print s[j] by itself
            dp[i][j] = dp[i][j - 1] + 1;
            
            // Look for matching characters to optimize
            for (int k = i; k < j; ++k) {
                if (unique_s[k] == unique_s[j]) {
                    int left_cost = dp[i][k];
                    int right_cost = (k + 1 <= j - 1) ? dp[k + 1][j - 1] : 0;
                    
                    dp[i][j] = min(dp[i][j], left_cost + right_cost);
                }
            }
        }
    }
    
    return dp[0][n - 1];
}

int main() {
    string s = "abaabab";
    
    cout << "Output: " << strangePrinter(s) << "\n";
    // Expected Output: 3
    
    return 0;
}