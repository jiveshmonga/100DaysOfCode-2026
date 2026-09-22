import java.util.*;

public class Question2 {
    public static long minCost(int n, int[] signal) {
        long[] dp = new long[n];
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                long diff = (long) signal[j] - signal[i];
                dp[j] = Math.min(dp[j], dp[i] + diff * diff);
            }
        }
        return dp[n - 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of relay stations: ");
        int n = sc.nextInt();

        int[] signal = new int[n];

        System.out.println("Enter the signal strengths of " + n + " relay stations:");
        for (int i = 0; i < n; i++) {
            signal[i] = sc.nextInt();
        }
        System.out.println("Minimum cost required: " + minCost(n, signal));
        sc.close();
    }
}