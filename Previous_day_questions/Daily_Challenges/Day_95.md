<h2 align="center">Week 14 Day 95 (17/09/2026)</h2>

## 1. N-th Tribonacci Number

The Tribonacci sequence `Tn` is defined as follows:

- `T0 = 0`
- `T1 = 1`
- `T2 = 1`
- `T(n+3) = T(n) + T(n+1) + T(n+2)`, for `n >= 0`

Given an integer `n`, determine the value of `Tn`.

This problem helps build concepts like:
- Dynamic Programming
- Recurrence Relations
- Sequence Processing
- Space Optimization

### Task

Return the nth Tribonacci number.

### Input

An integer:
- `n`, representing the position in the Tribonacci sequence.

### Constraints

- `0 <= n <= 37`
- The answer is guaranteed to fit within a 32-bit integer.
- `answer <= 2^31 - 1`

### Output

Return the value of `Tn`.

### Example 1

**Input:**
```text
n = 4
```

**Output:**
```text
4
```

### Example 2

**Input:**
```text
n = 25
```

**Output:**
```text
1389537
```

---

## 2. The Festival Schedule

You are helping organize a university festival where several activities are planned throughout the day. Each activity requires a certain amount of time and provides a specific amount of happiness points if completed.

You have a limited amount of time available, so you cannot participate in every activity. Each activity can either be selected completely or skipped; you cannot partially participate in an activity.

Your goal is to select activities such that the total time spent does not exceed your available time, while maximizing the total happiness points earned.

This problem helps build concepts like:
- Dynamic Programming
- 0/1 Knapsack
- Optimization
- Resource Allocation

### Task

Given the available time and the list of activities with their durations and happiness values, determine the maximum happiness points you can achieve.

You must solve the problem using Dynamic Programming.

### Input

An integer `n` representing the number of activities, followed by an integer `T` representing the total time available.

You are also given two arrays:
- `duration[]` — the time required for each activity.
- `happiness[]` — the happiness points earned by completing each activity.

### Constraints

- `1 <= n <= 1000`
- `1 <= T <= 10^5`
- `1 <= duration[i] <= 10^5`
- `1 <= happiness[i] <= 10^6`

### Output

Return the maximum total happiness points that can be obtained without exceeding the available time `T`.

### Example 1

**Input:**
```text
n = 4
T = 7
duration = [2, 3, 4, 5]
happiness = [4, 5, 7, 8]
```

**Output:**
```text
12
```

---
