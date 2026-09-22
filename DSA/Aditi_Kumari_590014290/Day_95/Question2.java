package Day_95;

class Question2 {
    public int maxHappiness(int T, int[] duration, int[] happiness) {
        int n = duration.length;
        int[] dp = new int[T + 1];

        for (int i = 0; i < n; i++) {
            for (int t = T; t >= duration[i]; t--) {
                dp[t] = Math.max(dp[t], happiness[i] + dp[t - duration[i]]);
            }
        }

        return dp[T];
    }
}