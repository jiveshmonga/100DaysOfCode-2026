import java.util.*;

public class Question2 {
    public static int minCost(int[] signal) {
        int n = signal.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // start station cost = 0

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int cost = dp[i] + (signal[j] - signal[i]) * (signal[j] - signal[i]);
                dp[j] = Math.min(dp[j], cost);
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int n = 5;
        int[] signal = {10, 30, 20, 40, 25};
        System.out.println(minCost(signal)); // Output: 125
    }
}
