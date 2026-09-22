import java.util.*;

class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;

        int[] points = new int[m + 2];

        points[0] = 0;
        points[m + 1] = n;

        for (int i = 0; i < m; i++) {
            points[i + 1] = cuts[i];
        }

        Arrays.sort(points);

        int[][] dp = new int[m + 2][m + 2];

        for (int len = 2; len < m + 2; len++) {
            for (int left = 0; left + len < m + 2; left++) {
                int right = left + len;
                dp[left][right] = Integer.MAX_VALUE;

                for (int k = left + 1; k < right; k++) {
                    int cost = points[right] - points[left]
                             + dp[left][k]
                             + dp[k][right];

                    dp[left][right] = Math.min(dp[left][right], cost);
                }
            }
        }

        return dp[0][m + 1];
    }
}
