import java.util.*;

public class Main {

    static int strangePrinter(String s) {
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

                        int middle = (k + 1 <= j - 1)
                                ? dp[k + 1][j - 1]
                                : 0;

                        dp[i][j] = Math.min(
                                dp[i][j],
                                dp[i][k] + middle
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