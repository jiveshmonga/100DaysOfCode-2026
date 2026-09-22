import java.util.Arrays;

class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        // Build sorted boundary array: 0, all cuts sorted, n
        int[] points = new int[m + 2];
        points[0] = 0;
        points[m + 1] = n;
        for (int i = 0; i < m; i++) points[i + 1] = cuts[i];
        Arrays.sort(points);

        int size = points.length; // m + 2
        int[][] dp = new int[size][size];
        // dp[i][j] initialized to 0 by default -> handles the j == i+1 base case

        // Fill by increasing interval width (gap between indices)
        for (int gap = 2; gap < size; gap++) {
            for (int i = 0; i + gap < size; i++) {
                int j = i + gap;
                int best = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int cost = dp[i][k] + dp[k][j] + (points[j] - points[i]);
                    best = Math.min(best, cost);
                }
                // If no k exists (gap==1 handled by init), best stays MAX only if loop never ran,
                // but gap>=2 guarantees at least one k, so best is always set.
                dp[i][j] = best;
            }
        }

        return dp[0][size - 1];
    }
}s
