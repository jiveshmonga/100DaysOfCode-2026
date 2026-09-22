<h2 align="center">Week 14 Day 7 (20/09/2026) — Weekly Debug 14</h2>

## 1. The Infinity Gauntlet Snap

### Solution

### Fixed Code

```c
#include <stdio.h>

int main() {
    int r, c;
    scanf("%d %d", &r, &c);

    int grid[r][c];

    for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
            scanf("%d", &grid[i][j]);

    int p;
    scanf("%d", &p);

    int portals[p][3];

    // BUG 1: i <= p accesses portals[p], which is outside the valid range.
    // Fixed: i < p
    for (int i = 0; i < p; i++)
        scanf("%d %d %d", &portals[i][0], &portals[i][1], &portals[i][2]);

    // BUG 2: Portal bonuses were added after the DP calculation.
    // Fixed: Add each bonus to its grid cell before calculating DP.
    for (int k = 0; k < p; k++) {
        int pr = portals[k][0];
        int pc = portals[k][1];
        int bonus = portals[k][2];

        grid[pr][pc] += bonus;
    }

    int dp[r][c];

    dp[0][0] = grid[0][0];

    // BUG 3: The first row must only come from the left.
    // Fixed: Initialize the first row separately.
    for (int j = 1; j < c; j++)
        dp[0][j] = dp[0][j - 1] + grid[0][j];

    // BUG 4: The first column must only come from above.
    // Fixed: Initialize the first column separately.
    for (int i = 1; i < r; i++)
        dp[i][0] = dp[i - 1][0] + grid[i][0];

    for (int i = 1; i < r; i++) {
        for (int j = 1; j < c; j++) {

            // BUG 5: The path must select the maximum valid energy
            // from the top and left cells.
            if (dp[i - 1][j] > dp[i][j - 1])
                dp[i][j] = dp[i - 1][j];
            else
                dp[i][j] = dp[i][j - 1];

            dp[i][j] += grid[i][j];
        }
    }

    // Correct endpoint: bottom-right cell (r-1, c-1).
    printf("%d\n", dp[r - 1][c - 1]);

    return 0;
}
```

### Output

```text
Test Case 1: 66
Test Case 2: 22
Test Case 3: 12
```

### Complexity

- **Time Complexity:** `O(R × C + P)`
- **Space Complexity:** `O(R × C + P)`

**Inbuilt function:** `scanf()` and `printf()` are used for input and output. No additional function is added.

---
