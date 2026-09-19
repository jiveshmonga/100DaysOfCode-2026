import java.util.*;

public class Question2 {
    public static long minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] p = new int[m + 2];
        p[0] = 0; p[m + 1] = n;
        System.arraycopy(cuts, 0, p, 1, m);
        Arrays.sort(p);

        long[][] dp = new long[m + 2][m + 2];
        int[][] opt = new int[m + 2][m + 2];

        for (int i = 0; i <= m; i++) opt[i][i + 1] = i + 1;

        for (int len = 2; len < m + 2; len++)
            for (int i = 0; i + len < m + 2; i++) {
                int j = i + len;
                long best = Long.MAX_VALUE;
                for (int k = opt[i][j - 1]; k <= opt[i + 1][j]; k++) {
                    long cost = dp[i][k] + dp[k][j];
                    if (cost < best) {
                        best = cost;
                        opt[i][j] = k;
                    }
                }
                dp[i][j] = best + p[j] - p[i];
            }

        return dp[0][m + 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of stick: ");
        int n = sc.nextInt();

        System.out.print("Enter the number of cuts: ");
        int m = sc.nextInt();
    
        int[] cuts = new int[m];
        boolean[] seen = new boolean[n];
        System.out.println("Enter the " + m + " distinct cut positions:");

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            if (x < 1 || x >= n || seen[x]) {
                System.out.println("Invalid or duplicate cut position.");
                return;
            }
            seen[x] = true;
            cuts[i] = x;
        }
        System.out.println("Minimum total cost: " + minCost(n, cuts));
        sc.close();
    }
}