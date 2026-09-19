class Solution {
    public long minCost(int[] signal) {
        int n = signal.length;

        long[] dp = new long[n];

        // Initially, all costs are infinity
        java.util.Arrays.fill(dp, Long.MAX_VALUE);

        // Starting station
        dp[0] = 0;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                long difference = signal[i] - signal[j];

                long cost = difference * difference;

                dp[i] = Math.min(dp[i], dp[j] + cost);
            }
        }

        return dp[n - 1];
    }
}
