import java.util.*;

public class Question2 {

    public static int strangePrinter(String s) {
        int n = s.length();

        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                dp[i][j] = dp[i + 1][j] + 1;

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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String s = sc.next();

        System.out.println(strangePrinter(s));

        sc.close();
    }
}