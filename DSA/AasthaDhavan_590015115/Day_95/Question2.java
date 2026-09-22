import java.util.*;
class Question2 {
    public static void main(String[] args) {
        int T = 7;
        int[] duration = {2, 3, 4, 5};
        int[] happiness = {4, 5, 7, 8};
        int n = duration.length;
        int[][] dp = new int[n + 1][T + 1];
        for (int i = 1; i <= n; i++) {
            for (int t = 0; t <= T; t++) {
                dp[i][t] = dp[i - 1][t];
                if (duration[i - 1] <= t) {
                    dp[i][t] = Math.max(
                        dp[i][t],
                        happiness[i - 1] + dp[i - 1][t - duration[i - 1]]
                    );
                }
            }
        }
        System.out.println(dp[n][T]);
    }
}