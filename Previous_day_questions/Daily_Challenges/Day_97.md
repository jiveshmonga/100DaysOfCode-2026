<h2 align="center">Week 14 Day 97 (19/09/2026)</h2>

## 1. Coin Change

This problem teaches Coin Change - finding the minimum number of items needed to reach an exact target when every denomination is available in unlimited supply. Related topics: Dynamic Programming, Unbounded Knapsack, Bottom Up Tabulation.

A cashier has an unlimited supply of coins in `n` different denominations. A customer is owed a certain amount of money, and the cashier wants to hand it over using as few coins as possible. If no combination of the available coins can add up to exactly that amount, the exchange is impossible.

This problem helps build concepts like:
- Dynamic Programming
- Unbounded Knapsack
- Bottom Up Tabulation
- Minimum Optimization

### Task

Determine the smallest number of coins needed to make up exactly the given amount, or report that it cannot be done.

### Input

- First line contains two integers `n` and `amount` – the number of coin denominations and the target amount.
- Second line contains `n` integers, where `coins[i]` is the value of the i-th denomination.

### Constraints

- `1 <= n <= 12`
- `1 <= coins[i] <= 2^31 - 1`, and all values are distinct
- `0 <= amount <= 10^4`

### Output

Print the minimum number of coins needed to make the amount, or `-1` if it is impossible.

### Example 1

**Input:**
```text
coins = [1,2,5], amount = 11
```

**Output:**
```text
3
```

### Example 2

**Input:**
```text
coins = [2], amount = 3
```

**Output:**
```text
-1
```

---

## 2. The Energy Tower

A robot is climbing a tower that has `N` floors, numbered 1 to N from the bottom. Floor `i` stores `energy[i]` units of energy. The robot starts on floor 1, collecting its energy right away, and its goal is to reach floor N.

From whichever floor it is standing on, it can move up by exactly 1 floor or by exactly 2 floors. Every time the robot lands on a floor, it absorbs the energy stored there.

### Task

Find the maximum total energy the robot can collect on its way from floor 1 to floor N.

### Input

- First line contains an integer `N` - the number of floors in the tower.
- Second line contains `N` integers, where the i-th integer is `energy[i]`, the energy stored on floor i.

### Constraints

- `2 <= N <= 10^5`
- `-10^4 <= energy[i] <= 10^4` (a negative value means the floor drains energy)
- The robot can always reach floor N, since it may move 1 floor at a time
- The answer fits in a 32-bit signed integer

### Output

Print a single integer - the maximum total energy the robot can collect.

### Example 1

**Input:**
```text
N = 6
energy = [5,10,20,15,25,30]
```

**Output:**
```text
105
```

### Example 2

**Input:**
```text
N = 5
energy = [4,-10,6,-3,8]
```

**Output:**
```text
18
```

---
