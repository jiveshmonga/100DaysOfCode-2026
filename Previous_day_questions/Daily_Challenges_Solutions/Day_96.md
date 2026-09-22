<h2 align="center">Week 14 Day 96 (18/09/2026)</h2>

## 1. Minimum Path Sum

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

int minPathSum(vector<vector<int>>& grid) {
    int m = grid.size();
    int n = grid[0].size();

    vector<int> dp(n, 0);

    dp[0] = grid[0][0];

    for (int j = 1; j < n; j++) {
        dp[j] = dp[j - 1] + grid[0][j];
    }

    for (int i = 1; i < m; i++) {
        dp[0] += grid[i][0];

        for (int j = 1; j < n; j++) {
            dp[j] = min(dp[j], dp[j - 1]) + grid[i][j];
        }
    }

    return dp[n - 1];
}
```

- **Time Complexity:** `O(m × n)`
- **Space Complexity:** `O(n)`

The solution uses Dynamic Programming. `dp[j]` represents the minimum path sum needed to reach the current cell in column `j`.

For every cell, we can arrive either from the cell above or from the cell on the left. Therefore, we choose the smaller of these two values and add the current grid value.

**Optimized solution:** Yes. A 2D DP table would require `O(m × n)` space. Since each cell only depends on the current row and the previous row, the DP is optimized to a one-dimensional array requiring `O(n)` space.

**Inbuilt function:** `std::min()` is used to select the smaller path sum.

---

## 2. The Signal Relay

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

long long minSignalCost(int n, vector<int>& signal) {
    vector<long long> dp(n, LLONG_MAX);

    dp[0] = 0;

    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i; j++) {
            long long diff = signal[i] - signal[j];
            long long cost = diff * diff;

            dp[i] = min(dp[i], dp[j] + cost);
        }
    }

    return dp[n - 1];
}
```

- **Time Complexity:** `O(n²)`
- **Space Complexity:** `O(n)`

The solution uses Dynamic Programming. `dp[i]` represents the minimum cost required to reach station `i`.

For every station `i`, all previous stations `j` are considered as possible jumping points. The cost of jumping from `j` to `i` is `(signal[i] - signal[j])²`. We select the minimum total cost among all possible previous stations.

**Optimized solution:** Yes. The DP approach avoids explicitly checking every possible sequence of jumps. The one-dimensional DP uses `O(n)` space. For the given constraint `n <= 2000`, the `O(n²)` solution is appropriate.

**Inbuilt function:** `std::min()` is used to maintain the minimum cost.

---
