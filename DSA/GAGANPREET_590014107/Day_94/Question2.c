#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int minCost(int n, int cuts[], int m) {
    int points[m + 2];

    points[0] = 0;
    points[m + 1] = n;

    for (int i = 0; i < m; i++) {
        points[i + 1] = cuts[i];
    }

    qsort(points, m + 2, sizeof(int), compare);

    int dp[m + 2][m + 2];

    for (int i = 0; i < m + 2; i++) {
        for (int j = 0; j < m + 2; j++) {
            dp[i][j] = 0;
        }
    }

    for (int len = 2; len < m + 2; len++) {
        for (int i = 0; i + len < m + 2; i++) {
            int j = i + len;
            dp[i][j] = INT_MAX;

            for (int k = i + 1; k < j; k++) {
                int cost = points[j] - points[i]
                         + dp[i][k]
                         + dp[k][j];

                if (cost < dp[i][j]) {
                    dp[i][j] = cost;
                }
            }
        }
    }

    return dp[0][m + 1];
}

int main() {
    int n = 7;
    int cuts[] = {1, 3, 4, 5};
    int m = 4;

    printf("%d\n", minCost(n, cuts, m));

    return 0;
}
