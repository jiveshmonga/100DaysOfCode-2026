<h2 align="center">Week 14 Day 97 (19/09/2026)</h2>

## 1. Coin Change

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

int coinChange(vector<int>& coins, int amount) {
    vector<int> dp(amount + 1, amount + 1);

    dp[0] = 0;

    for (int current = 1; current <= amount; current++) {
        for (int coin : coins) {
            if (coin <= current) {
                dp[current] = min(dp[current],
                                  dp[current - coin] + 1);
            }
        }
    }

    return dp[amount] > amount ? -1 : dp[amount];
}
```

- **Time Complexity:** `O(amount × n)`
- **Space Complexity:** `O(amount)`

The solution uses Bottom Up Dynamic Programming. `dp[current]` represents the minimum number of coins required to make the amount `current`.

For every amount, each available coin is considered. Since every denomination can be used an unlimited number of times, the same coin can be considered again for the remaining amount.

**Optimized solution:** Yes. The one-dimensional DP table reduces the space from a two-dimensional DP approach to `O(amount)` while maintaining `O(amount × n)` time complexity.

**Inbuilt function:** `std::min()` is used to select the minimum number of coins.

---

## 2. The Energy Tower

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

int maxEnergy(int N, vector<int>& energy) {
    vector<int> dp(N);

    dp[0] = energy[0];
    dp[1] = energy[1] + energy[0];

    for (int i = 2; i < N; i++) {
        dp[i] = energy[i] + max(dp[i - 1], dp[i - 2]);
    }

    return dp[N - 1];
}
```

- **Time Complexity:** `O(N)`
- **Space Complexity:** `O(N)`

The solution uses Dynamic Programming. `dp[i]` represents the maximum total energy that can be collected when reaching floor `i`.

The robot can reach floor `i` from either floor `i - 1` or floor `i - 2`. Therefore, we take the maximum energy obtainable from those two previous floors and add the energy of the current floor.

**Optimized solution:** Yes. The DP can be further optimized to `O(1)` space because each state only depends on the previous two states.

```cpp
#include <bits/stdc++.h>
using namespace std;

int maxEnergy(int N, vector<int>& energy) {
    int prev2 = energy[0];
    int prev1 = energy[0] + energy[1];

    for (int i = 2; i < N; i++) {
        int current = energy[i] + max(prev1, prev2);
        prev2 = prev1;
        prev1 = current;
    }

    return prev1;
}
```

- **Optimized Space Complexity:** `O(1)`

**Inbuilt function:** `std::max()` is used to select the better of the two possible previous states.

---
