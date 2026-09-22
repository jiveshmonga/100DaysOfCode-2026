class Solution {
    public int strangePrinter(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];

        // Single character needs 1 turn
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Length of substring
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                // Print s[j] separately
                dp[i][j] = dp[i][j - 1] + 1;

                // Try to combine same characters
                for (int k = i; k < j; k++) {

                    if (s[k] == s[j]) {

                        int value = dp[i][k];

                        if (k + 1 <= j - 1) {
                            value += dp[k + 1][j - 1];
                        }

                        dp[i][j] = Math.min(dp[i][j], value);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}