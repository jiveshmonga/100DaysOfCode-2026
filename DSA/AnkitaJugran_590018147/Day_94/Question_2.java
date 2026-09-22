import java.util.*;

class MinCost_to_Cut_tree {

    public int minCost(int n, int[] cuts) {

        int m = cuts.length;

        // Create array with boundaries
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

        // length = number of points between i and j
        for (int length = 2; length < m + 2; length++) {

            for (int i = 0; i + length < m + 2; i++) {

                int j = i + length;

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

    public static void main(String[] args) {

        MinCost_to_Cut_tree obj = new MinCost_to_Cut_tree();

        int n = 7;
        int[] cuts = {1, 3, 4, 5};

        System.out.println(obj.minCost(n, cuts));
    }
}