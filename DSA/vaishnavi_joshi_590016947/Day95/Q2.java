class Solution {
    public int maxHappiness(int n, int T, int[] duration, int[] happiness) {

        // dp[t] = maximum happiness possible with t time
        int[] dp = new int[T + 1];

        for (int i = 0; i < n; i++) {

            // Traverse backwards for 0/1 Knapsack
            for (int t = T; t >= duration[i]; t--) {

                dp[t] = Math.max(
                    dp[t],
                    dp[t - duration[i]] + happiness[i]
                );
            }
        }

        return dp[T];
    }
}