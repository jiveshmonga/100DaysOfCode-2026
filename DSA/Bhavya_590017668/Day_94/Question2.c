#include <stdio.h>
#include <stdlib.h>
int min(int a, int b) {
    return a < b ? a : b;
}
int minCost(int n, int cuts[], int cutsSize) {
    int m = cutsSize + 2;
    int *arr = (int *)malloc(m * sizeof(int));
    arr[0] = 0;
    arr[m - 1] = n;
    for (int i = 0; i < cutsSize; i++)
        arr[i + 1] = cuts[i];
    for (int i = 0; i < m - 1; i++) {
        for (int j = i + 1; j < m; j++) {
            if (arr[i] > arr[j]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
    int dp[m][m];
    for (int i = 0; i < m; i++)
        for (int j = 0; j < m; j++)
            dp[i][j] = 0;
    for (int len = 2; len < m; len++) {
        for (int i = 0; i + len < m; i++) {
            int j = i + len;
            dp[i][j] = 1000000000;
            for (int k = i + 1; k < j; k++) {
                int cost = dp[i][k] + dp[k][j] + arr[j] - arr[i];
                dp[i][j] = min(dp[i][j], cost);
            }
        }
    }
    int result = dp[0][m - 1];
    free(arr);
    return result;
}
int main() {
    int n = 7;
    int cuts[] = {1, 3, 4, 5};
    printf("%d\n", minCost(n, cuts, 4));
    return 0;
}