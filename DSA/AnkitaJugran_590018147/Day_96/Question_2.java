import java.util.*;

class SignalRelay {

    public static int maxHappiness(int T, int[] duration, int[] happiness) {

        int n = duration.length;

        // dp[i][t] = maximum happiness using first i activities
        // with maximum available time t
        int[][] dp = new int[n + 1][T + 1];

        // Fill the DP table
        for (int i = 1; i <= n; i++) {

            for (int t = 0; t <= T; t++) {

                // Option 1: Skip the current activity
                dp[i][t] = dp[i - 1][t];

                // Option 2: Take the current activity
                if (duration[i - 1] <= t) {

                    dp[i][t] = Math.max(
                        dp[i][t],
                        happiness[i - 1] + dp[i - 1][t - duration[i - 1]]
                    );
                }
            }
        }

        return dp[n][T];
    }

    public static void main(String[] args) {

        int T = 7;

        int[] duration = {2, 3, 4, 5};

        int[] happiness = {4, 5, 7, 8};

        int result = maxHappiness(T, duration, happiness);

        System.out.println("Maximum Happiness: " + result);
    }
}