#include <stdio.h>

int main() {
    int n;
    scanf("%d", &n);

    int energy[n];

    for (int i = 0; i < n; i++) {
        scanf("%d", &energy[i]);
    }

    int dp[n];

    dp[0] = energy[0];

    if (n > 1)
        dp[1] = energy[1] + dp[0];

    for (int i = 2; i < n; i++) {
        int maxPrev = dp[i - 1] > dp[i - 2] ? dp[i - 1] : dp[i - 2];
        dp[i] = energy[i] + maxPrev;
    }

    printf("%d\n", dp[n - 1]);

    return 0;
}
