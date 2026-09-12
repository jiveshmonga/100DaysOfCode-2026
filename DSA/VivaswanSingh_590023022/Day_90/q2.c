#include <stdio.h>

int videoStitching(int clips[][2], int clipsSize, int time)
{
    int currentEnd = 0;
    int farthest = 0;
    int count = 0;

    while (currentEnd < time)
    {
        farthest = currentEnd;

        for (int i = 0; i < clipsSize; i++)
        {
            if (clips[i][0] <= currentEnd && clips[i][1] > farthest)
            {
                farthest = clips[i][1];
            }
        }

        if (farthest == currentEnd)
            return -1;

        currentEnd = farthest;
        count++;
    }

    return count;
}

int main()
{
    int clips[][2] = {
        {0, 2},
        {1, 6},
        {4, 8},
        {7, 10},
        {9, 12}
    };

    int clipsSize = sizeof(clips) / sizeof(clips[0]);
    int time = 10;

    int result = videoStitching(clips, clipsSize, time);

    printf("Minimum clips: %d\n", result);

    return 0;
}