//Given a university festival with several activities, each requiring a certain amount of time and providing 
//a specific number of happiness points, select a combination of activities whose total duration does not exceed 
//the available time while maximizing total happiness. Each activity must either be completed fully or skipped. 
//The solution must use Dynamic Programming.
//Input: T = 7, duration = [2, 3, 4, 5], happiness = [4, 5, 7, 8]. Output: 12.
#include <stdio.h>

int maxHappiness(int T, int duration[], int happiness[], int n) {
    int dp[n + 1][T + 1];
    for (int i = 0; i <= n; i++) {
        for (int t = 0; t <= T; t++) {
            if (i == 0 || t == 0)
                dp[i][t] = 0;
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int t = 1; t <= T; t++) {
            if (duration[i - 1] <= t) {
                int include = happiness[i - 1] +
                              dp[i - 1][t - duration[i - 1]];
                int exclude = dp[i - 1][t];
                dp[i][t] = (include > exclude) ? include : exclude;
            }
            else {
                dp[i][t] = dp[i - 1][t];
            }
        }
    }
    return dp[n][T];
}

int main() {
    int T, n;
    printf("Enter number of activities: ");
    scanf("%d", &n);
    printf("Enter available time: ");
    scanf("%d", &T);
    int duration[n], happiness[n];
    printf("Enter durations:\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &duration[i]);
    printf("Enter happiness points:\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &happiness[i]);
    printf("Maximum Happiness: %d\n",
           maxHappiness(T, duration, happiness, n));
return 0;
}