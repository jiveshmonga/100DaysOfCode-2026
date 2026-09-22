#include <stdio.h>
int max(int a, int b) {
    return a > b ? a : b;
}
int main() {
    int T = 7;
    int duration[] = {2, 3, 4, 5};
    int happiness[] = {4, 5, 7, 8};
    int n = 4;
    int dp[n + 1][T + 1];
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= T; j++) {
            dp[i][j] = 0;
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= T; j++) {
            if (duration[i - 1] <= j)
                dp[i][j] = max(dp[i - 1][j], happiness[i - 1] + dp[i - 1][j - duration[i - 1]]);
            else
                dp[i][j] = dp[i - 1][j];
        }
    }
    printf("%d\n", dp[n][T]);
    return 0;
}