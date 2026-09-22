<h2 align="center">Week 14 Day 92 (14/09/2026)</h2>

## 1. Climbing Stairs (LeetCode #70)
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

int climbStairs(int n) {
    if (n <= 2)
        return n;

    int prev2 = 1;
    int prev1 = 2;

    for (int i = 3; i <= n; i++) {
        int current = prev1 + prev2;
        prev2 = prev1;
        prev1 = current;
    }

    return prev1;
}

int main() {
    int n;
    cin >> n;

    cout << climbStairs(n) << "\n";
    return 0;
}
```

* Time: O(n) — the staircase is processed once from step 3 to step n.
* Space: O(1) — only three integer variables are used.

The dynamic programming recurrence is based on the fact that the last move can either be a 1-step move or a 2-step move. Therefore, the number of ways to reach step `n` is the sum of the ways to reach steps `n-1` and `n-2`.

**Optimized solution:** Instead of storing the complete DP array, only the previous two values are required. This reduces the space complexity from O(n) to O(1).

**Inbuilt function:** No special inbuilt function is required. The solution uses a simple iterative dynamic programming approach.

---

## 2. House Robber
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

long long rob(vector<int>& nums) {
    long long prev2 = 0;
    long long prev1 = 0;

    for (int money : nums) {
        long long current = max(prev1, prev2 + money);
        prev2 = prev1;
        prev1 = current;
    }

    return prev1;
}

int main() {
    int n;
    cin >> n;

    vector<int> nums(n);

    for (int i = 0; i < n; i++)
        cin >> nums[i];

    cout << rob(nums) << "\n";
    return 0;
}
```

* Time: O(n) — each house is processed exactly once.
* Space: O(1) extra space — only two previous DP states are maintained.

The dynamic programming approach maintains the maximum amount that can be robbed up to the previous two houses. For each house, there are two choices: skip the current house and keep the previous maximum, or rob the current house and add its money to the maximum from two houses earlier.

**Optimized solution:** The standard DP array would require O(n) space. Since only the previous two states are needed to calculate the current state, the solution can be optimized to O(1) extra space.

**Inbuilt function:** `std::max()` from the `<algorithm>` header is used to choose the larger amount between robbing and skipping the current house.
