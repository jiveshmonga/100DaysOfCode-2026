class Solution {
    public int minCost(int[] signal) {
        int n = signal.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int j = 0; j < i; j++) {
                int diff = signal[i] - signal[j];
                int cost = diff * diff;

                dp[i] = Math.min(dp[i], dp[j] + cost);
            }
        }

        return dp[n - 1];
    }
}