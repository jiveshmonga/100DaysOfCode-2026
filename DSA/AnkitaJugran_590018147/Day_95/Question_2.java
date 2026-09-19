import java.util.*;
//0/1knapsack


public class FestivalSchedule {

    public static int maxHappiness(int T, int[] duration, int[] happiness) {

        int n = duration.length;

        // dp[i][t] = maximum happiness using first i activities
        // with at most t time available
        int[][] dp = new int[n + 1][T + 1];

        for (int i = 1; i <= n; i++) {

            for (int t = 1; t <= T; t++) {

                // Skip the current activity
                dp[i][t] = dp[i - 1][t];

                // Take the current activity if it fits
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

        System.out.println("Maximum Happiness = " + result);
    }
}