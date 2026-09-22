import java.util.*;

class Solution {
    public int strangePrinter(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = 1 + dp[i + 1][j];

                for (int k = i + 1; k <= j; k++) {

                    if (s.charAt(i) == s.charAt(k)) {

                        int middle = (k == i + 1)
                                   ? 0
                                   : dp[i + 1][k - 1];

                        dp[i][j] = Math.min(
                            dp[i][j],
                            middle + dp[k][j]
                        );
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}