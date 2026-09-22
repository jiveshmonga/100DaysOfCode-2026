<h2 align="center">Day 99 (21/09/2026)</h2>

## 1. First Missing Positive

This problem teaches an efficient in-place technique for finding the smallest positive integer that does not appear in an unsorted collection. Related topics: Arrays, In-Place Hashing, Cyclic Sort.

You are given an array of integers, which may contain duplicates, zeros, and negative numbers in any order. Among all the positive integers, some may be missing from the array while others may repeat. Your task is to identify the smallest positive integer that is absent from the array.

This problem helps build concepts like:
- Arrays
- In-Place Hashing
- Cyclic Sort
- Index Mapping

### Task

Find the smallest positive integer (`1, 2, 3, ...`) that does not occur anywhere in the given array.

### Input

- First line contains an integer `n` – the size of the array.
- Second line contains `n` integers, the elements of the array.

### Constraints

- `1 <= n <= 5 x 10^5`
- `-2^31 <= nums[i] <= 2^31 - 1`

### Output

Print a single integer – the smallest positive integer missing from the array.

### Example 1

**Input:**
```text
nums = [1,2,0]
```

**Output:**
```text
3
```

### Example 2

**Input:**
```text
nums = [3,4,-1,1]
```

**Output:**
```text
2
```

---

## 2. Counting Landmasses

This problem teaches how to identify and count connected groups of cells in a grid. Related topics: Graph Traversal, Depth First Search / Breadth First Search, Connected Components.

You are given a rectangular grid representing a map, where each cell is marked either as land or water. Two land cells belong to the same landmass if one can be reached from the other by moving horizontally or vertically through a chain of adjacent land cells; diagonal connections do not count. The entire grid is bordered by water on all four sides.

### Task

Determine how many separate landmasses exist on the map.

### Input

- First line contains two integers `m` and `n` – the number of rows and columns in the grid.
- Next `m` lines each contain a string of `n` characters (`'1'` for land, `'0'` for water), representing one row of the grid.

### Constraints

- `1 <= m <= 300`
- `1 <= n <= 300`
- Each grid cell is either `'0'` or `'1'`

### Output

Print a single integer – the total number of landmasses in the grid.

### Example 1

**Input:**
```text
grid = ["11110","11010","11000","00000"]
```

**Output:**
```text
1
```

### Example 2

**Input:**
```text
grid = ["11000","11000","00100","00011"]
```

**Output:**
```text
3
```

---
