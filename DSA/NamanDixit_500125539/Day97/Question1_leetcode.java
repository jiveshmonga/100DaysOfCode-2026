class Question1_leetcode {

    public int coinChange(int[] coins, int amount) {

        // Create DP array
        // dp[i] = minimum number of coins needed
        // to make amount i
        int[] dp = new int[amount + 1];

        // Fill the array with a value that means
        // "we cannot make this amount yet"
        //
        // amount + 1 is safe because we can never
        // need more than 'amount' coins
        // when the smallest coin is 1.
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        // To make amount 0, we need 0 coins
        dp[0] = 0;

        // Calculate the answer for every amount
        for (int i = 1; i <= amount; i++) {

            // Try every coin
            for (int j = 0; j < coins.length; j++) {

                // Get the current coin
                int coin = coins[j];

                // We can use this coin only if
                // it is not bigger than the current amount
                if (coin <= i) {

                    // Take the minimum:
                    //
                    // dp[i]              → don't use this coin
                    //
                    // dp[i - coin] + 1   → use this coin
                    //
                    // +1 means we are using
                    // one current coin

                    dp[i] = Math.min(
                        dp[i],
                        dp[i - coin] + 1
                    );
                }
            }
        }

        // If the answer is still amount + 1,
        // it means the amount cannot be made
        if (dp[amount] == amount + 1) {
            return -1;
        }

        // Otherwise return the minimum number of coins
        return dp[amount];
    }
}