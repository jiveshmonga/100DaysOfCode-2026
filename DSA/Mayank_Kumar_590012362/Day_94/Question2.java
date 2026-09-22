import java.util.*;
class Solution {
    public int minCost(int n, int[] c) {
        int m = c.length;
        int[] a = new int[m + 2];

        for (int i = 0; i < m; i++) a[i + 1] = c[i];
        a[0] = 0;
        a[m + 1] = n;
        Arrays.sort(a);

        int[][] dp = new int[m + 2][m + 2];

        for (int l = 2; l <= m + 1; l++) {
            for (int i = 0; i + l <= m + 1; i++) {
                int j = i + l;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                        a[j] - a[i] + dp[i][k] + dp[k][j]);
                }
            }
        } return dp[0][m + 1];
    }
}