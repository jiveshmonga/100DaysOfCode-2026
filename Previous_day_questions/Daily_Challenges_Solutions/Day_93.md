<h2 align="center">Week 14 Day 93 (15/09/2026)</h2>

## 1. Counting Bits

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

vector<int> countBits(int n) {
    vector<int> ans(n + 1, 0);

    for (int i = 1; i <= n; i++) {
        ans[i] = ans[i >> 1] + (i & 1);
    }

    return ans;
}
```

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

The solution uses Dynamic Programming. For every number `i`, the number of set bits can be obtained from `i >> 1` and the last bit of `i`. Therefore:

`ans[i] = ans[i >> 1] + (i & 1)`

This avoids repeatedly checking every bit of every number.

**Optimized solution:** Yes. The DP relation gives `O(n)` time and avoids an additional bit-counting loop for every number.

**Inbuilt function:** No built-in function is used to directly count set bits, as required by the problem.

---

## 2. Strange Printer

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

int strangePrinter(string s) {
    int n = s.size();

    vector<vector<int>> dp(n, vector<int>(n, 0));

    for (int i = n - 1; i >= 0; i--) {
        dp[i][i] = 1;

        for (int j = i + 1; j < n; j++) {
            dp[i][j] = dp[i + 1][j] + 1;

            for (int k = i + 1; k <= j; k++) {
                if (s[k] == s[i]) {
                    int middle = (k == i + 1) ? 0 : dp[i + 1][k - 1];
                    dp[i][j] = min(dp[i][j], middle + dp[k][j]);
                }
            }
        }
    }

    return dp[0][n - 1];
}
```

- **Time Complexity:** `O(n^3)`
- **Space Complexity:** `O(n^2)`

The solution uses Interval Dynamic Programming. `dp[i][j]` represents the minimum number of turns needed to print the substring from index `i` to `j`.

Initially, we can print `s[i]` separately and solve the remaining substring. If another position `k` contains the same character as `s[i]`, the printer can combine these printing operations, reducing the total number of turns.

**Optimized solution:** Yes. The interval DP avoids trying every possible sequence of printing operations directly. The standard DP approach runs in `O(n^3)` time with `O(n^2)` space.

**Inbuilt function:** `std::min()` is used to keep the minimum number of turns.

---
