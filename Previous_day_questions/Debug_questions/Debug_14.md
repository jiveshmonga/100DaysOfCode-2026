<h2 align="center">Week 14 Day 7 (20/09/2026) — Weekly Debug 14</h2>

## 1. The Infinity Gauntlet Snap

Thanos has collected all six Infinity Stones. When he snaps, half of all life across the Multiverse will be erased. The Avengers have one chance - each hero must navigate a dimensional grid to reach the Infinity Gauntlet before the snap completes.

Each cell in the grid holds a certain amount of energy. Heroes can only move right or down. Doctor Strange has identified certain dimensional portals (fixed positions) that grant a massive energy boost when stepped on.

The code contains syntax, logical, and runtime issues. It may compile, but the strategy is flawed. Heroes are taking suboptimal paths, the boost is not applying correctly, and the endpoints are wrong.

Find and fix every bug before the snap.

This problem helps build concepts like:
- Dynamic Programming
- Grid Traversal
- Path Optimization
- Portal-Based Bonuses

**Your task:** Identify and fix all bugs in the given code so that the hero collects the maximum possible energy while moving from the top-left cell to the bottom-right cell.

### What the Code Must Do

- Read the dimensions of the grid (rows `R`, columns `C`).
- Read the energy values for each cell in the grid.
- Read the number of portal positions with bonus energy.
- Read each portal position `(row, col)` and its bonus energy.
- A hero starts at the top-left `(0,0)` and moves only right or down to the bottom-right `(R-1,C-1)`.
- When stepping on a portal cell, add its bonus energy after adding the cell's own energy.
- Print the maximum possible energy the hero can collect.

### Buggy Code

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

    for (int i = 0; i <= p; i++)
        scanf("%d %d %d", &portals[i][0], &portals[i][1], &portals[i][2]);

    int dp[r][c];
    dp[0][0] = grid[0][0];

    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            if (i == 0 && j == 0) continue;

            int fromTop = (i > 0) ? dp[i-1][j] : 0;
            int fromLeft = (j > 0) ? dp[i][j-1] : 0;

            if (fromTop > fromLeft)
                dp[i][j] = fromTop;
            else
                dp[i][j] = fromLeft;

            dp[i][j] += grid[i][j];
        }
    }

    for (int k = 0; k < p; k++) {
        int pr = portals[k][0];
        int pc = portals[k][1];
        int bonus = portals[k][2];
        dp[pr][pc] += bonus;
    }

    printf("%d\n", dp[r-1][c-1]);
    return 0;
}
```

### Expected Output

**Test Case 1**

3×3 grid with all values 10, portal at `(1,1)` with bonus 16:

```text
66
```

**Test Case 2**

2×2 grid:
```text
4 2
5 8
```

Portal at `(0,1)` with bonus 8:

```text
22
```

**Test Case 3**

1×1 grid with value 5, portal at `(0,0)` with bonus 7:

```text
12
```

### Constraints

- `1 <= R, C <= 100`
- `0 <= P <= R × C`
- `0 <= grid[i][j] <= 10^4`
- `0 <= bonus <= 10^5`
- `0 <= row < R` and `0 <= col < C`
- Each portal position is valid and contains at most one portal.
- Do not add any new functions.
- Fix all syntax, logical, and runtime errors.
- Some code may be missing entirely.
- The output must match exactly.
- Do not redesign the program or use additional data structures.

---
