#include <stdio.h>

int maxHappiness(int T, int duration[], int happiness[], int n) {
    int dp[n + 1][T + 1];

    // Initialize DP table
    for (int i = 0; i <= n; i++) {
        for (int t = 0; t <= T; t++) {
            dp[i][t] = 0;
        }
    }

    // 0/1 Knapsack
    for (int i = 1; i <= n; i++) {
        for (int t = 1; t <= T; t++) {

            // Skip the activity
            dp[i][t] = dp[i - 1][t];

            // Take the activity if it fits
            if (duration[i - 1] <= t) {
                int take = happiness[i - 1] +
                           dp[i - 1][t - duration[i - 1]];

                if (take > dp[i][t]) {
                    dp[i][t] = take;
                }
            }
        }
    }

    return dp[n][T];
}

int main() {
    int T, n;

    scanf("%d", &T);
    scanf("%d", &n);

    int duration[n];
    int happiness[n];

    for (int i = 0; i < n; i++) {
        scanf("%d", &duration[i]);
    }

    for (int i = 0; i < n; i++) {
        scanf("%d", &happiness[i]);
    }

    printf("%d\n", maxHappiness(T, duration, happiness, n));

    return 0;
}
