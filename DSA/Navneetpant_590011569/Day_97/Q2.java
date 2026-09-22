class Solution {
    public int maxEnergy(int[] energy) {
        int n = energy.length;
        int[] dp = new int[n];
        dp[0] = energy[0];
        dp[1] = energy[1] + dp[0];

        for (int i = 2; i < n; i++) {
            dp[i] = energy[i] + Math.max(dp[i - 1], dp[i - 2]);
        }

        return dp[n - 1];
    }
}