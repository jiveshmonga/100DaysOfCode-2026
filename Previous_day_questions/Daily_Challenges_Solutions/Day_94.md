<h2 align="center">Week 14 Day 94 (16/09/2026)</h2>

## 1. Divisor Game

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

bool divisorGame(int n) {
    return n % 2 == 0;
}
```

- **Time Complexity:** `O(1)`
- **Space Complexity:** `O(1)`

The key observation is that Alice wins exactly when `n` is even. If `n` is even, Alice can choose `x = 1`, making the number odd. From an odd number, every divisor is odd, so subtracting any valid divisor makes the number even again. This lets Alice maintain the winning position.

For odd `n`, Alice's move always produces an even number, giving Bob the corresponding winning strategy.

**Optimized solution:** Yes. The mathematical observation reduces the solution to constant time and constant space.

**Inbuilt function:** No special inbuilt function is required.

---

## 2. Minimum Cost to Cut a Stick

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

int minCost(int n, vector<int>& cuts) {
    int m = cuts.size();

    cuts.push_back(0);
    cuts.push_back(n);

    sort(cuts.begin(), cuts.end());

    vector<vector<int>> dp(m + 2, vector<int>(m + 2, 0));

    for (int len = 2; len < m + 2; len++) {
        for (int i = 0; i + len < m + 2; i++) {
            int j = i + len;
            dp[i][j] = INT_MAX;

            for (int k = i + 1; k < j; k++) {
                int cost = cuts[j] - cuts[i]
                         + dp[i][k]
                         + dp[k][j];

                dp[i][j] = min(dp[i][j], cost);
            }
        }
    }

    return dp[0][m + 1];
}
```

- **Time Complexity:** `O(m^3)`
- **Space Complexity:** `O(m^2)`

The solution uses Interval Dynamic Programming. First, `0` and `n` are added as the two endpoints of the stick, and the cut positions are sorted.

`dp[i][j]` represents the minimum cost to perform all required cuts between `cuts[i]` and `cuts[j]`.

For every interval, each possible cut `k` is considered as the first cut. The cost of making that cut is the current interval length, followed by the optimal costs of the two resulting intervals.

**Optimized solution:** Yes. Interval DP avoids trying every possible ordering of cuts explicitly. The standard DP solution runs in `O(m^3)` time and `O(m^2)` space, which is suitable for `m <= 100`.

**Inbuilt function:** `std::sort()` is used to arrange the cut positions, and `std::min()` is used to select the minimum cost.

---
