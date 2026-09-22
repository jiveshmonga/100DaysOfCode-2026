package Day_96;
class Question2 {
    public int maxHappiness(int T, int[] duration, int[] happiness) {
        int n = duration.length;

        int[][] dp = new int[n + 1][T + 1];
        for (int i = 1; i <= n; i++) {
            for (int t = 1; t <= T; t++) {
                dp[i][t] = dp[i - 1][t];

                if (duration[i - 1] <= t) {
                    dp[i][t] = Math.max(
                        dp[i][t],
                        happiness[i - 1] + dp[i - 1][t - duration[i - 1]]
                    );
                }
            }
        }
        return dp[n][T];
    }
}