class Solution {
    public int maxHappiness(int T, int[] d, int[] h) {
        int[] dp = new int[T + 1];
        for (int i = 0; i < d.length; i++) {
            for (int j = T; j >= d[i]; j--) dp[j] = Math.max(dp[j], dp[j - d[i]] + h[i]);
        } return dp[T];
    }
}