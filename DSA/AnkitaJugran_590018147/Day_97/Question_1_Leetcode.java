class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        // Initialize with an impossible value
        Arrays.fill(dp, amount + 1);

        // 0 coins are needed to make amount 0
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (coin <= i) {
                    dp[i] = Math.min(dp[i],
                                     dp[i - coin] + 1);
                }
            }
        }

        // Check if the amount is possible
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
