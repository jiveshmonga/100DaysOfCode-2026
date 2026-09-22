import java.util.*;

public class Question2 {

    public static int minCost(int n, int[] cuts) {
        int m = cuts.length;

        int[] points = new int[m + 2];

        for (int i = 0; i < m; i++) {
            points[i + 1] = cuts[i];
        }

        points[0] = 0;
        points[m + 1] = n;

        Arrays.sort(points);

        int[][] dp = new int[m + 2][m + 2];

        for (int len = 2; len < m + 2; len++) {
            for (int i = 0; i + len < m + 2; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;

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
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] cuts = new int[m];

        for (int i = 0; i < m; i++) {
            cuts[i] = sc.nextInt();
        }

        System.out.println(minCost(n, cuts));

        sc.close();
    }
}