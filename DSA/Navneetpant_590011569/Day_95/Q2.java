class Solution {
    public int maxHappiness(int n, int T, int[] duration, int[] happiness) {       
        int[] dp = new int[T + 1];
        for (int i = 0; i < n; i++) {

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