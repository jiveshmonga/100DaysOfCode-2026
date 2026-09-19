class Solution {
    public int maxHappiness(int[] time, int[] happiness, int T) {

        int n = time.length;

        int[] dp = new int[T + 1];

        for (int i = 0; i < n; i++) {

            for (int t = T; t >= time[i]; t--) {

                dp[t] = Math.max(
                    dp[t],
                    dp[t - time[i]] + happiness[i]
                );
            }
        }

        return dp[T];
    }
}
