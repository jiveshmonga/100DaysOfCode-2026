<h2 align="center">Week 14 Day 96 (18/09/2026)</h2>

## 1. Minimum Path Sum

You are given an `m x n` grid containing non-negative integers.

Your goal is to find a path from the top-left cell to the bottom-right cell such that the sum of all numbers along the path is minimum.

At any point, you can move only in one of two directions:
- Right
- Down

This problem helps build concepts like:
- Dynamic Programming
- Grid Traversal
- Path Optimization
- 2D Arrays

### Task

Return the minimum possible sum of all numbers along a valid path from the top-left corner to the bottom-right corner.

### Input

A 2D integer array:
- `grid`, an `m x n` grid where `grid[i][j]` represents the value of the cell at row i and column j.

### Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 200`
- `0 <= grid[i][j] <= 200`

### Output

Return the minimum path sum from the top-left cell to the bottom-right cell.

### Example 1

**Input:**
```text
grid = [[1,3,1],[1,5,1],[4,2,1]]
```

**Output:**
```text
7
```

### Example 2

**Input:**
```text
grid = [[1,2,3],[4,5,6]]
```

**Output:**
```text
12
```

---

## 2. The Signal Relay

You are designing a communication system with `n` relay stations arranged in a straight line. Each station has a signal strength value.

Starting from the first station, you want to reach the last station. From any station, you can jump forward to another station, but the cost of a jump depends on the difference in signal strengths between the two stations.

For a jump from station `i` to station `j`, the cost is:

`(signal[j] - signal[i])²`

You may jump over any number of intermediate stations.

Your objective is to reach the final station with the minimum possible total cost.

This problem helps build concepts like:
- Dynamic Programming
- Optimization
- Array Processing
- Minimum Cost Path

### Task

Given the signal strengths of all relay stations, determine the minimum cost required to travel from the first station to the last station.

You must solve the problem using Dynamic Programming.

### Input

An integer `n` representing the number of relay stations, followed by an integer array `signal[]`.

- `signal[i]` represents the signal strength at station i.

### Constraints

- `2 <= n <= 2000`
- `1 <= signal[i] <= 10^5`

### Output

Return the minimum cost required to reach the last relay station.

### Example 1

**Input:**
```text
n = 5
signal = [10, 30, 20, 40, 25]
```

**Output:**
```text
125
```

---
