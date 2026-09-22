class Solution {
    public long minCost(int[] signal) {
        int n = signal.length;

        long[] dp = new long[n];

        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            dp[i] = Long.MAX_VALUE;

            for (int j = 0; j < i; j++) {
                long diff = signal[i] - signal[j];
                long cost = diff * diff;

                dp[i] = Math.min(dp[i], dp[j] + cost);
            }
        }

        return dp[n - 1];
    }
}
