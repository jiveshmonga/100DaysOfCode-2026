<h2 align="center">Week 14 Day 94 (16/09/2026)</h2>

## 1. Divisor Game

Alice and Bob take turns playing a game, with Alice making the first move.

Initially, there is a number `n` on the chalkboard. On each player's turn, the player must choose any integer `x` such that `0 < x < n` and `n % x == 0`, then replace `n` with `n - x`.

If a player cannot make a valid move, that player loses the game. Both players play optimally.

This problem helps build concepts like:
- Dynamic Programming
- Game Theory
- Mathematical Reasoning
- Optimal Strategy

### Task

Return `true` if Alice wins the game, and `false` otherwise.

### Input

An integer:
- `n`, representing the initial number on the chalkboard.

### Constraints

- `1 <= n <= 1000`

### Output

Return `true` if Alice can win the game with optimal play; otherwise, return `false`.

### Example 1

**Input:**
```text
n = 2
```

**Output:**
```text
true
```

### Example 2

**Input:**
```text
n = 3
```

**Output:**
```text
false
```

---

## 2. Minimum Cost to Cut a Stick

You are given a wooden stick of length `n`. The stick is initially uncut, and you need to make several cuts at specified positions.

Each cut costs an amount equal to the length of the stick being cut at that moment. After making a cut, the stick is divided into two smaller pieces, and future cuts can be made on either piece.

Your goal is to determine the minimum total cost required to make all the given cuts.

You must solve the problem using Dynamic Programming.

This problem helps build concepts like:
- Dynamic Programming
- Interval DP
- Optimization
- Sorting

### Task

Determine the minimum possible total cost to perform all the cuts.

### Input

An integer `n` representing the length of the stick, followed by an integer `m` representing the number of cuts, and an array `cuts[]` containing the positions where the stick must be cut.

### Constraints

- `2 <= n <= 10^6`
- `1 <= m <= 100`
- `1 <= cuts[i] < n`
- All values in `cuts[]` are distinct.

### Output

Return the minimum total cost required to make all the cuts.

### Example 1

**Input:**
```text
n = 7
m = 4
cuts = [1,3,4,5]
```

**Output:**
```text
16
```

---
