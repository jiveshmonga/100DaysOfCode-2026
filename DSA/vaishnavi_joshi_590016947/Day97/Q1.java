import java.util.*;

class Solution {
    public int coinChange(int[] coins, int amount) {

        // dp[i] = minimum coins needed to make amount i
        int[] dp = new int[amount + 1];

        // Initialize with a value greater than any possible answer
        Arrays.fill(dp, amount + 1);

        // 0 coins are needed to make amount 0
        dp[0] = 0;

        // Calculate answer for every amount
        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (coin <= i) {
                    dp[i] = Math.min(
                        dp[i],
                        dp[i - coin] + 1
                    );
                }
            }
        }

        // If amount cannot be formed
        return dp[amount] > amount ? -1 : dp[amount];
    }
}