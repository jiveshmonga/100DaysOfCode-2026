#include <stdio.h>
#include <stdlib.h>

struct Clip {
    int start;
    int end;
};

int compare(const void *a, const void *b) {
    struct Clip *x = (struct Clip *)a;
    struct Clip *y = (struct Clip *)b;

    return x->start - y->start;
}

int videoStitching(struct Clip clips[], int n, int time) {
    // Sort clips by starting time
    qsort(clips, n, sizeof(struct Clip), compare);

    int currentEnd = 0;
    int farthest = 0;
    int count = 0;
    int i = 0;

    while (currentEnd < time) {

        // Find the clip that extends coverage the farthest
        while (i < n && clips[i].start <= currentEnd) {
            if (clips[i].end > farthest)
                farthest = clips[i].end;

            i++;
        }

        // Cannot extend the covered interval
        if (farthest == currentEnd)
            return -1;

        count++;
        currentEnd = farthest;
    }

    return count;
}

int main() {
    int n, time;

    printf("Enter number of clips: ");
    scanf("%d", &n);

    struct Clip clips[n];

    printf("Enter start and end times:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d %d", &clips[i].start, &clips[i].end);
    }

    printf("Enter required time: ");
    scanf("%d", &time);

    int result = videoStitching(clips, n, time);

    printf("Minimum number of clips: %d\n", result);

    return 0;
}