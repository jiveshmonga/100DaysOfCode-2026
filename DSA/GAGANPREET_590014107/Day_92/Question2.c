#include <stdio.h>

int videoStitching(int** clips, int clipsSize,
                   int* clipsColSize, int time) {
    int count = 0;
    int currentEnd = 0;
    int farthest = 0;
    int i = 0;

    while (currentEnd < time) {
        // Find the farthest reachable end
        while (i < clipsSize &&
               clips[i][0] <= currentEnd) {

            if (clips[i][1] > farthest) {
                farthest = clips[i][1];
            }

            i++;
        }

        // No clip can extend the coverage
        if (farthest == currentEnd) {
            return -1;
        }

        count++;
        currentEnd = farthest;
    }

    return count;
}
