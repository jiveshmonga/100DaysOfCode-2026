//Given a wooden stick of length n and a list of positions where cuts must be made, determine the minimum total cost to perform 
//all cuts. Each cut costs the length of the stick segment being cut at that moment. You must solve the problem using 
//Dynamic Programming.
//Input: n = 7, cuts = [1, 3, 4, 5]. Output: 16.
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int minCost(int n, int* cuts, int cutsSize) {
    int m = cutsSize + 2;
    int *pos = (int *)malloc(m * sizeof(int));
    pos[0] = 0;
    pos[m - 1] = n;
    for (int i = 0; i < cutsSize; i++) {
        pos[i + 1] = cuts[i];
    }
    qsort(pos, m, sizeof(int), compare);
    int **dp = (int **)malloc(m * sizeof(int *));
    for (int i = 0; i < m; i++) {
        dp[i] = (int *)calloc(m, sizeof(int));
    }
    for (int len = 2; len < m; len++) {
        for (int i = 0; i + len < m; i++) {
            int j = i + len;
            dp[i][j] = INT_MAX;
            for (int k = i + 1; k < j; k++) {
                int cost = dp[i][k]
                         + dp[k][j]
                         + (pos[j] - pos[i]);
                if (cost < dp[i][j]) {
                    dp[i][j] = cost;
                }
            }
            if (dp[i][j] == INT_MAX)
                dp[i][j] = 0;
        }
    }
    int result = dp[0][m - 1];
    for (int i = 0; i < m; i++)
        free(dp[i]);
    free(dp);
    free(pos);
    return result;
}

int main() {
    int n, cutsSize;
    scanf("%d", &n);
    scanf("%d", &cutsSize);
    int *cuts = (int *)malloc(cutsSize * sizeof(int));
    for (int i = 0; i < cutsSize; i++) {
        scanf("%d", &cuts[i]);
    }
    printf("%d\n", minCost(n, cuts, cutsSize));
    free(cuts);
    return 0;
}