#include <stdio.h>

int main() {
    int T, n;

    scanf("%d", &T);
    scanf("%d", &n);

    int duration[n], happiness[n];

    for (int i = 0; i < n; i++) {
        scanf("%d", &duration[i]);
    }

    for (int i = 0; i < n; i++) {
        scanf("%d", &happiness[i]);
    }

    int dp[n + 1][T + 1];

    for (int i = 0; i <= n; i++) {
        for (int t = 0; t <= T; t++) {
            if (i == 0 || t == 0) {
                dp[i][t] = 0;
            }
            else if (duration[i - 1] <= t) {
                int take = happiness[i - 1]
                         + dp[i - 1][t - duration[i - 1]];

                int skip = dp[i - 1][t];

                dp[i][t] = (take > skip) ? take : skip;
            }
            else {
                dp[i][t] = dp[i - 1][t];
            }
        }
    }

    printf("%d\n", dp[n][T]);

    return 0;
}
