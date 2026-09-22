#include <stdio.h>

int festivalSchedule(int T, int duration[], int happiness[], int n)
{
    int dp[T + 1];

    for (int t = 0; t <= T; t++)
        dp[t] = 0;

    for (int i = 0; i < n; i++)
    {
        for (int t = T; t >= duration[i]; t--)
        {
            int value = dp[t - duration[i]] + happiness[i];

            if (value > dp[t])
                dp[t] = value;
        }
    }

    return dp[T];
}

int main()
{
    int T = 7;

    int duration[] = {2, 3, 4, 5};
    int happiness[] = {4, 5, 7, 8};

    int n = sizeof(duration) / sizeof(duration[0]);

    int result = festivalSchedule(T, duration, happiness, n);

    printf("Maximum happiness: %d\n", result);

    return 0;
}