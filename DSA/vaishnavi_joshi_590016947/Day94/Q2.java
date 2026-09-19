import java.util.*;

class Solution {
    public int minCost(int n, int[] cuts) {

        int m = cuts.length;

        // Add 0 and n
        int[] points = new int[m + 2];

        points[0] = 0;
        points[m + 1] = n;

        for (int i = 0; i < m; i++) {
            points[i + 1] = cuts[i];
        }

        // Sort cut positions
        Arrays.sort(points);

        // dp[i][j] = minimum cost to cut between points[i] and points[j]
        int[][] dp = new int[m + 2][m + 2];

        // Length of interval between i and j
        for (int len = 2; len < m + 2; len++) {

            for (int i = 0; i + len < m + 2; i++) {

                int j = i + len;

                dp[i][j] = Integer.MAX_VALUE;

                // Try every possible first cut
                for (int k = i + 1; k < j; k++) {

                    int cost = points[j] - points[i]
                             + dp[i][k]
                             + dp[k][j];

                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][m + 1];
    }
}