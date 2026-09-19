#include <stdlib.h>
int compare(const void *a, const void *b)
{
    int **p = (int **)a;
    int **q = (int **)b;
    if ((*p)[1] < (*q)[1])
        return -1;
    else if ((*p)[1] > (*q)[1])
        return 1;
    else
        return 0;
}
int findMinArrowShots(int** points, int pointsSize, int* pointsColSize)
{
    if (pointsSize == 0)
        return 0;
    qsort(points, pointsSize, sizeof(int *), compare);
    int arrows = 1;
    long long arrowPosition = points[0][1];
    for (int i = 1; i < pointsSize; i++)
    {
        if ((long long)points[i][0] > arrowPosition)
        {
            arrows++;
            arrowPosition = points[i][1];
        }
    }
    return arrows;
}