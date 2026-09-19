import java.util.*;

public class Question2 {

    public static long maxHappiness(int n, int T, int[] duration, int[] happiness) {

        long[] dp = new long[T + 1];

        for (int i = 0; i < n; i++) {

            for (int t = T; t >= duration[i]; t--) {

                dp[t] = Math.max(
                    dp[t],
                    dp[t - duration[i]] + happiness[i]
                );
            }
        }

        return dp[T];
    }

    public static void main(String[] args) {

        int n = 4;
        int T = 7;

        int[] duration = {2, 3, 4, 5};
        int[] happiness = {4, 5, 7, 8};

        System.out.println(maxHappiness(n, T, duration, happiness));
    }
}