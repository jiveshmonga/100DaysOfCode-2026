class Solution {
    public int maxHappiness(int[] time, int[] happiness, int totalTime) {
        int n = time.length;

        int[][] dp = new int[n + 1][totalTime + 1];

        for (int i = 1; i <= n; i++) {
            for (int t = 0; t <= totalTime; t++) {

                dp[i][t] = dp[i - 1][t];

                if (time[i - 1] <= t) {
                    dp[i][t] = Math.max(
                        dp[i][t],
                        happiness[i - 1] + dp[i - 1][t - time[i - 1]]
                    );
                }
            }
        }

        return dp[n][totalTime];
    }
}
