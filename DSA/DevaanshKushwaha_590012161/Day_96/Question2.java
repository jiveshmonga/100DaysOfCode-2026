class Solution {
    public int maxHappiness(int T, int[] duration, int[] happiness) {
        int n = duration.length;
        // dp[i][t]: max happiness using first i activities within time t
        int[][] dp = new int[n + 1][T + 1];

        for (int i = 1; i <= n; i++) {
            int dur = duration[i - 1];
            int joy = happiness[i - 1];

            for (int t = 0; t <= T; t++) {
                // Option 1: skip this activity
                dp[i][t] = dp[i - 1][t];

                // Option 2: take this activity, if it fits within time t
                if (dur <= t) {
                    dp[i][t] = Math.max(dp[i][t], dp[i - 1][t - dur] + joy);
                }
            }
        }

        return dp[n][T];
    }
}
