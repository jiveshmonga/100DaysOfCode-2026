<h2 align="center">Week 14 Day 93 (15/09/2026)</h2>

## 1. Counting Bits

Given an integer `n`, return an array `ans` of length `n + 1` such that for each `i` (`0 <= i <= n`), `ans[i]` is the number of `1`s in the binary representation of `i`.

Do not use built-in functions to directly count the number of set bits.

This problem helps build concepts like:
- Dynamic Programming
- Binary Representation
- Bit Manipulation
- Array Processing

### Task

Return an array where `ans[i]` represents the number of `1`s in the binary representation of `i`.

### Input

An integer:
- `n`, representing the maximum number for which the number of set bits must be calculated.

### Constraints

- `0 <= n <= 10^5`

### Output

Return an integer array `ans` of length `n + 1`, where `ans[i]` is the number of `1`s in the binary representation of `i`.

### Example 1

**Input:**
```text
n = 2
```

**Output:**
```text
[0,1,1]
```

### Example 2

**Input:**
```text
n = 5
```

**Output:**
```text
[0,1,1,2,1,2]
```

---

## 2. Strange Printer

You are given a string `s` consisting of lowercase English letters. You have a strange printer that can print a sequence of the same character in a single turn.

In each turn, the printer can print a character over any contiguous range. It can also print over characters that have already been printed.

Your goal is to determine the minimum number of turns required to print the entire string.

You must solve the problem using Dynamic Programming.

This problem helps build concepts like:
- Dynamic Programming
- Interval DP
- String Processing
- Optimization

### Task

Determine the minimum number of turns required to print the given string.

### Input

An integer `n` representing the length of the string, followed by a string `s`.

### Constraints

- `1 <= n <= 100`
- `s` consists only of lowercase English letters.

### Output

Return the minimum number of turns required to print the entire string.

### Example 1

**Input:**
```text
n = 7
s = "abaabab"
```

**Output:**
```text
3
```

---
