class Solution {
    public int festivalSchedule(int T, int[] duration, int[] happiness) {
        int n = duration.length;
        int[][] dp = new int[n + 1][T + 1];
        
        for (int i = 1; i <= n; i++) {
            int dur = duration[i - 1];
            int hap = happiness[i - 1];
            
            for (int t = 0; t <= T; t++) {
                // Option 1: skip activity i
                dp[i][t] = dp[i - 1][t];
                
                // Option 2: take activity i, if it fits
                if (dur <= t) {
                    dp[i][t] = Math.max(dp[i][t], hap + dp[i - 1][t - dur]);
                }
            }
        }
        
        return dp[n][T];
    }
}
