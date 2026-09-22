<h2 align="center">Day 99 (21/09/2026)</h2>

## 1. First Missing Positive

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

int firstMissingPositive(vector<int>& nums) {
    int n = nums.size();

    for (int i = 0; i < n; i++) {
        while (nums[i] >= 1 && nums[i] <= n &&
               nums[nums[i] - 1] != nums[i]) {
            swap(nums[i], nums[nums[i] - 1]);
        }
    }

    for (int i = 0; i < n; i++) {
        if (nums[i] != i + 1)
            return i + 1;
    }

    return n + 1;
}
```

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

The solution uses In-Place Hashing / Cyclic Sort. Every positive number `x` in the range `1` to `n` is placed at index `x - 1`. After rearranging the array, the first index `i` where `nums[i] != i + 1` identifies the smallest missing positive integer.

Values that are negative, zero, or greater than `n` can be ignored because the answer must lie between `1` and `n + 1`.

**Optimized solution:** Yes. The solution runs in `O(n)` time and uses `O(1)` extra space without creating a separate hash set or array.

**Inbuilt function:** `std::swap()` is used to place values at their correct indices.

---

## 2. Counting Landmasses

### Solution

```cpp
#include <bits/stdc++.h>
using namespace std;

void dfs(vector<string>& grid, int i, int j) {
    int m = grid.size();
    int n = grid[0].size();

    if (i < 0 || i >= m || j < 0 || j >= n ||
        grid[i][j] == '0') {
        return;
    }

    grid[i][j] = '0';

    dfs(grid, i - 1, j);
    dfs(grid, i + 1, j);
    dfs(grid, i, j - 1);
    dfs(grid, i, j + 1);
}

int countLandmasses(vector<string>& grid) {
    int m = grid.size();
    int n = grid[0].size();
    int count = 0;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == '1') {
                count++;
                dfs(grid, i, j);
            }
        }
    }

    return count;
}
```

- **Time Complexity:** `O(m × n)`
- **Space Complexity:** `O(m × n)` in the worst case due to the DFS recursion stack.

The solution uses Depth First Search to find connected components. Whenever an unvisited land cell (`'1'`) is found, a new landmass is counted and DFS visits all horizontally and vertically connected land cells belonging to that landmass.

The grid itself is modified by changing visited land cells from `'1'` to `'0'`, so a separate visited matrix is not required.

**Optimized solution:** Yes. The grid is used to mark visited cells in-place, reducing auxiliary space compared with maintaining a separate `visited` matrix. The traversal still requires `O(m × n)` time.

**Inbuilt function:** No special inbuilt function is required. The DFS traversal is implemented using a user-defined helper function.

---
