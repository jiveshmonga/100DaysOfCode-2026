int coinChange(int* coins, int coinsSize, int amount)
{
    int *dp = (int *)malloc((amount + 1) * sizeof(int));

    for (int i = 0; i <= amount; i++)
        dp[i] = amount + 1;

    dp[0] = 0;

    for (int i = 1; i <= amount; i++)
    {
        for (int j = 0; j < coinsSize; j++)
        {
            if (coins[j] <= i)
            {
                int current = dp[i - coins[j]] + 1;

                if (current < dp[i])
                    dp[i] = current;
            }
        }
    }

    if (dp[amount] == amount + 1)
    {
        free(dp);
        return -1;
    }

    int answer = dp[amount];

    free(dp);
    return answer;
}