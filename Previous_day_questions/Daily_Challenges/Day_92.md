<h2 align="center">Week 14 Day 92 (14/09/2026)</h2>

## 1. Climbing Stairs (LeetCode #70)

A problem that teaches dynamic programming by finding the number of distinct ways to reach the top of a staircase.

You are climbing a staircase. It takes `n` steps to reach the top. Each time, you can either climb 1 step or 2 steps. Your goal is to determine the number of distinct ways you can climb to the top of the staircase.

This problem helps build concepts like:
- Dynamic programming
- Recursion
- Memoization
- Fibonacci-style recurrence

which are important for solving problems where the current result depends on previously computed results.

**Your task:** Return the number of distinct ways to reach the top of the staircase.

### Input
An integer:
- `n`, representing the total number of steps in the staircase.

**Constraints:**
- `1 <= n <= 45`

### Output
Return the number of distinct ways to climb to the top.

### Examples

**Input:**
```text
n = 2
```

**Output:**
```text
2
```

---

**Input:**
```text
n = 3
```

**Output:**
```text
3
```

---

## 2. House Robber

A problem that teaches dynamic programming for maximizing the amount collected while avoiding adjacent selections.

You are given an integer array `nums` where `nums[i]` represents the amount of money available in the `i`-th house. You are planning to rob the houses, but there is one important restriction: you cannot rob two adjacent houses, because the security system will be triggered.

Your goal is to determine the maximum amount of money you can rob without robbing two adjacent houses.

This problem helps build concepts like:
- Dynamic programming
- State transition
- Optimal substructure
- Maximum value optimization

which are important for solving problems where choices at the current position depend on previous decisions.

**Your task:** Determine the maximum amount of money that can be robbed while ensuring that no two adjacent houses are robbed. You must solve the problem using Dynamic Programming.

### Input
An integer `n`, representing the number of houses, followed by an integer array:
- `nums`, where `nums[i]` represents the amount of money in the `i`-th house.

**Constraints:**
- `1 <= n <= 10^5`
- `0 <= nums[i] <= 10^9`

### Output
Return the maximum amount of money that can be robbed without robbing two adjacent houses.

### Examples

**Input:**
```text
n = 5
nums = [2, 7, 9, 3, 1]
```

**Output:**
```text
12
```

---
