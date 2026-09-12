#include <stdlib.h>

int compare(const void *a, const void *b) {
    int *x = *(int **)a;
    int *y = *(int **)b;

    if (x[0] != y[0])
        return x[0] - y[0];

    return x[1] - y[1];
}

int videoStitching(int** clips, int clipsSize, int* clipsColSize, int time) {
    qsort(clips, clipsSize, sizeof(int *), compare);

    int count = 0;
    int currentEnd = 0;
    int farthest = 0;
    int i = 0;

    while (currentEnd < time) {
        while (i < clipsSize && clips[i][0] <= currentEnd) {
            if (clips[i][1] > farthest)
                farthest = clips[i][1];

            i++;
        }

        if (farthest == currentEnd)
            return -1;

        count++;
        currentEnd = farthest;
    }

    return count;
}
