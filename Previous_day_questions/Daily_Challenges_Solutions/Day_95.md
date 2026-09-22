<h2 align="center">Week 14 Day 95 (17/09/2026)</h2>

## 1. N-th Tribonacci Number

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

int tribonacci(int n) {
    if (n == 0)
        return 0;

    if (n == 1 || n == 2)
        return 1;

    int t0 = 0;
    int t1 = 1;
    int t2 = 1;

    for (int i = 3; i <= n; i++) {
        int current = t0 + t1 + t2;
        t0 = t1;
        t1 = t2;
        t2 = current;
    }

    return t2;
}
```

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

The solution follows the Tribonacci recurrence and stores only the previous three values required to calculate the next value.

**Optimized solution:** Yes. Instead of maintaining a complete DP array of size `n + 1`, only three previous values are stored, reducing the space complexity to `O(1)`.

**Inbuilt function:** No special inbuilt function is required.

---

## 2. The Festival Schedule

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

int maxHappiness(int n, int T, vector<int>& duration,
                 vector<int>& happiness) {
    vector<int> dp(T + 1, 0);

    for (int i = 0; i < n; i++) {
        for (int time = T; time >= duration[i]; time--) {
            dp[time] = max(dp[time],
                           dp[time - duration[i]] + happiness[i]);
        }
    }

    return dp[T];
}
```

- **Time Complexity:** `O(nT)`
- **Space Complexity:** `O(T)`

This problem is a 0/1 Knapsack variant. Each activity can either be selected completely or skipped, so an activity can be used at most once.

`dp[time]` represents the maximum happiness that can be obtained using at most the given amount of time. The time loop runs backwards so that the same activity is not selected more than once.

**Optimized solution:** Yes. A standard 2D DP table would require `O(nT)` space. Using a one-dimensional DP array reduces the space complexity to `O(T)` while maintaining the same `O(nT)` time complexity.

**Inbuilt function:** `std::max()` is used to choose between skipping the activity and selecting it.

---
