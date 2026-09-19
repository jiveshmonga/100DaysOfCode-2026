#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b)
{
    return (*(int *)a - *(int *)b);
}

int minCost(int n, int cuts[], int cutsSize)
{
    int m = cutsSize + 2;

    int points[m];

    points[0] = 0;
    points[m - 1] = n;

    for (int i = 0; i < cutsSize; i++)
        points[i + 1] = cuts[i];

    qsort(points, m, sizeof(int), compare);

    int dp[m][m];

    for (int i = 0; i < m; i++)
        for (int j = 0; j < m; j++)
            dp[i][j] = 0;

    for (int len = 2; len < m; len++)
    {
        for (int i = 0; i + len < m; i++)
        {
            int j = i + len;
            dp[i][j] = 1000000000;

            for (int k = i + 1; k < j; k++)
            {
                int cost = dp[i][k] + dp[k][j] + points[j] - points[i];

                if (cost < dp[i][j])
                    dp[i][j] = cost;
            }
        }
    }

    return dp[0][m - 1];
}

int main()
{
    int n = 7;

    int cuts[] = {1, 3, 4, 5};
    int cutsSize = sizeof(cuts) / sizeof(cuts[0]);

    int result = minCost(n, cuts, cutsSize);

    printf("Minimum cost: %d\n", result);

    return 0;
}