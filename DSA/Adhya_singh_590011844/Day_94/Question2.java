import java.util.*;

public class Main {

    static long minCost(int n, int[] cuts) {
        int m = cuts.length;

        int[] points = new int[m + 2];

        points[0] = 0;
        points[m + 1] = n;

        for (int i = 0; i < m; i++) {
            points[i + 1] = cuts[i];
        }

        Arrays.sort(points);

        long[][] dp = new long[m + 2][m + 2];

        for (int len = 2; len < m + 2; len++) {

            for (int i = 0; i + len < m + 2; i++) {

                int j = i + len;

                dp[i][j] = Long.MAX_VALUE;

                for (int k = i + 1; k < j; k++) {

                    long cost = dp[i][k]
                              + dp[k][j]
                              + (points[j] - points[i]);

                    dp[i][j] = Math.min(dp[i][j], cost);
                }

                if (dp[i][j] == Long.MAX_VALUE) {
                    dp[i][j] = 0;
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