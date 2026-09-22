import java.util.*;

public class StrangePrinter {

    public static int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                dp[i][j] = dp[i][j - 1] + 1;

                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        int left = (k > i) ? dp[i][k - 1] : 0;
                        int middle = dp[k][j - 1];

                        dp[i][j] = Math.min(dp[i][j], left + middle);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        System.out.println(strangePrinter(s));

        sc.close();
    }
}
