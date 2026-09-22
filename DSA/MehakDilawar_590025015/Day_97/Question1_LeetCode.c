int coinChange(int* coins, int coinsSize, int amount) {
    int dp[amount + 1];
    for (int i = 0; i <= amount; i++) {
        dp[i] = amount + 1;
    }
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
        for (int j = 0; j < coinsSize; j++) {
            if (coins[j] <= i) {
                int temp = dp[i - coins[j]] + 1;
                if (temp < dp[i]) {
                    dp[i] = temp;
                }
            }
        }
    }
    if (dp[amount] > amount)
        return -1;
    return dp[amount];
}