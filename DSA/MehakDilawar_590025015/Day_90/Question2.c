//Given a collection of video clips represented by their start and end times, determine the minimum number of clips required to 
//cover the entire interval [0, time]. The clips can be cut and rearranged as needed, and the solution must use a greedy approach.
//Input: clips = [[0,2], [1,6], [4,8], [7,10], [9,12]], time = 10. Output: 4.
#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    int *x = *(int **)a;
    int *y = *(int **)b;
    if (x[0] == y[0])
        return y[1] - x[1];
    return x[0] - y[0];
}

int videoStitching(int **clips, int clipsSize, int *clipsColSize, int time) {
    if (time == 0)
        return 0;
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
        if (farthest <= currentEnd)
            return -1;
        currentEnd = farthest;
        count++;
    }
    return count;
}

int main() {
    int n, time;
    printf("Enter number of clips: ");
    scanf("%d", &n);
    int **clips = (int **)malloc(n * sizeof(int *));
    int *clipsColSize = (int *)malloc(n * sizeof(int));
    printf("Enter start and end time of each clip:\n");
    for (int i = 0; i < n; i++) {
        clips[i] = (int *)malloc(2 * sizeof(int));
        clipsColSize[i] = 2;
        scanf("%d %d", &clips[i][0], &clips[i][1]);
    }
    printf("Enter target time: ");
    scanf("%d", &time);
    int result = videoStitching(clips, n, clipsColSize, time);
    printf("Minimum number of clips = %d\n", result);
    for (int i = 0; i < n; i++)
        free(clips[i]);
    free(clips);
    free(clipsColSize);
return 0;
}