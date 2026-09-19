#include <stdio.h>
#include <string.h>

int strangePrinter(char *s)
{
    int n = strlen(s);

    if (n == 0)
        return 0;

    int dp[n][n];

    for (int i = 0; i < n; i++)
        dp[i][i] = 1;

    for (int len = 2; len <= n; len++)
    {
        for (int i = 0; i + len - 1 < n; i++)
        {
            int j = i + len - 1;

            dp[i][j] = dp[i][j - 1] + 1;

            for (int k = i; k < j; k++)
            {
                if (s[k] == s[j])
                {
                    int middle = 0;

                    if (k + 1 <= j - 1)
                        middle = dp[k + 1][j - 1];

                    int value = dp[i][k] + middle;

                    if (value < dp[i][j])
                        dp[i][j] = value;
                }
            }
        }
    }

    return dp[0][n - 1];
}

int main()
{
    char s[] = "aba";

    int result = strangePrinter(s);

    printf("Minimum turns: %d\n", result);

    return 0;
}