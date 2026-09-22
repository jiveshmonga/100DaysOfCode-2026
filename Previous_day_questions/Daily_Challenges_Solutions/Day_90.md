<h2 align="center">Week 13 Day 90 (12/09/2026)</h2>

## 1. Minimum Number of Arrows to Burst Balloons (LeetCode #452)
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

int findMinArrowShots(vector<vector<int>>& points) {
    sort(points.begin(), points.end(),
         [](const vector<int>& a, const vector<int>& b) {
             return a[1] < b[1];
         });

    int arrows = 1;
    long long arrowPosition = points[0][1];

    for (int i = 1; i < points.size(); i++) {
        if (points[i][0] > arrowPosition) {
            arrows++;
            arrowPosition = points[i][1];
        }
    }

    return arrows;
}

int main() {
    int n;
    cin >> n;

    vector<vector<int>> points(n, vector<int>(2));

    for (int i = 0; i < n; i++)
        cin >> points[i][0] >> points[i][1];

    cout << findMinArrowShots(points) << "\n";
    return 0;
}
```

* Time: O(n log n) — sorting the balloons by their ending position dominates the complexity.
* Space: O(log n) to O(n) depending on the implementation of `std::sort()`.

The greedy approach sorts all balloon intervals by their ending coordinate. An arrow is placed at the end of the first balloon. Every balloon containing that position is burst by the same arrow. When the next balloon starts after the current arrow position, it cannot be burst by the existing arrow, so a new arrow is required at that balloon's ending position.

**Optimized solution:** The sorting-based greedy approach is optimal for the general interval problem. Since the intervals are not bounded to a small coordinate range, sorting is required to process them efficiently.

**Inbuilt function:** `std::sort()` from the `<algorithm>` header is used with a custom comparator to sort balloons according to their ending coordinates.

---

## 2. Video Stitching
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

int videoStitching(vector<vector<int>>& clips, int time) {
    sort(clips.begin(), clips.end());

    int clipsUsed = 0;
    int currentEnd = 0;
    int farthestEnd = 0;
    int i = 0;
    int n = clips.size();

    while (currentEnd < time) {
        while (i < n && clips[i][0] <= currentEnd) {
            farthestEnd = max(farthestEnd, clips[i][1]);
            i++;
        }

        if (farthestEnd == currentEnd)
            return -1;

        clipsUsed++;
        currentEnd = farthestEnd;
    }

    return clipsUsed;
}

int main() {
    int n, time;
    cin >> n;

    vector<vector<int>> clips(n, vector<int>(2));

    for (int i = 0; i < n; i++)
        cin >> clips[i][0] >> clips[i][1];

    cin >> time;

    cout << videoStitching(clips, time) << "\n";
    return 0;
}
```

* Time: O(n log n) — sorting the clips dominates the total complexity.
* Space: O(log n) to O(n) depending on the implementation of `std::sort()`.

The greedy approach repeatedly considers all clips that start at or before the currently covered endpoint and chooses the one that extends coverage the farthest. This ensures the interval `[0, time]` is covered using the minimum possible number of clips. If no clip can extend the current coverage, covering the target interval is impossible.

**Optimized solution:** After sorting, the clips are scanned only once, making the greedy selection phase O(n). For arbitrary interval endpoints, the O(n log n) sorting step is the dominant and generally necessary preprocessing step.

**Inbuilt function:** `std::sort()` is used to arrange clips by starting time, and `std::max()` is used to continuously track the farthest reachable endpoint.
