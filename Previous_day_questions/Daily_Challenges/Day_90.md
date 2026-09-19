<h2 align="center">Week 13 Day 90 (12/09/2026)</h2>

## 1. Minimum Number of Arrows to Burst Balloons (LeetCode #452)

A problem that teaches greedy algorithms for selecting the minimum number of points required to cover overlapping intervals.

You are given some spherical balloons taped onto a flat wall representing the XY-plane. The balloons are represented by a 2D integer array `points`, where `points[i] = [xstart, xend]` denotes a balloon whose horizontal diameter stretches between `xstart` and `xend`.

You can shoot arrows vertically upward from different points along the x-axis. A balloon with `xstart` and `xend` is burst by an arrow shot at position `x` if:

```text
xstart <= x <= xend
```

A shot arrow continues traveling upward infinitely and can burst every balloon in its path.

This problem helps build concepts like:
- Greedy algorithms
- Interval scheduling
- Sorting intervals
- Overlap detection

which are important for solving interval and optimization problems efficiently.

**Your task:** Determine the minimum number of arrows required to burst all the balloons.

### Input
A 2D integer array:
- `points`, where `points[i] = [xstart, xend]` represents the horizontal range of the `i`-th balloon.

**Constraints:**
- `1 <= points.length <= 10^5`
- `points[i].length == 2`
- `-2^31 <= xstart < xend <= 2^31 - 1`

### Output
Return the minimum number of arrows required to burst all balloons.

### Examples

**Input:**
```text
points = [[10,16],[2,8],[1,6],[7,12]]
```

**Output:**
```text
2
```

---

**Input:**
```text
points = [[1,2],[3,4],[5,6],[7,8]]
```

**Output:**
```text
4
```

---

## 2. Video Stitching

A problem that teaches greedy algorithms for selecting the minimum number of intervals required to cover a target range.

You are given a collection of video clips, where each clip is represented by a start time and an end time. The clips can be cut and rearranged as needed. Your goal is to use the minimum number of clips to cover the entire time interval from `0` to `time`.

This problem helps build concepts like:
- Greedy algorithms
- Interval coverage
- Sorting intervals
- Range expansion

which are important for solving coverage and optimization problems efficiently.

**Your task:** Determine the minimum number of video clips required to cover the entire interval `[0, time]`. You must solve the problem using a greedy algorithm.

### Input
An integer `n` representing the number of video clips, followed by a 2D array:
- `clips`, where `clips[i] = [start, end]` represents the starting and ending time of the `i`-th clip.
- `time`, representing the total duration that needs to be covered.

**Constraints:**
- `1 <= n <= 10^5`
- `0 <= clips[i][0] < clips[i][1] <= 10^9`
- `1 <= time <= 10^9`

### Output
Return the minimum number of clips required to cover the entire interval `[0, time]`. If it is impossible to cover the entire interval, return `-1`.

### Examples

**Input:**
```text
n = 5
clips = [[0,2],[1,6],[4,8],[7,10],[9,12]]
time = 10
```

**Output:**
```text
4
```

---
