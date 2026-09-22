import java.util.*;

public class Main {

    static long maxHappiness(int n, int T, int[] duration, int[] happiness) {

        long[] dp = new long[T + 1];

        for (int i = 0; i < n; i++) {

            int time = duration[i];
            int value = happiness[i];

        
            for (int t = T; t >= time; t--) {
                dp[t] = Math.max(
                    dp[t],
                    dp[t - time] + value
                );
            }
        }

        return dp[T];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int T = sc.nextInt();

        int[] duration = new int[n];
        int[] happiness = new int[n];

        for (int i = 0; i < n; i++) {
            duration[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            happiness[i] = sc.nextInt();
        }

        System.out.println(
            maxHappiness(n, T, duration, happiness)
        );

        sc.close();
    }
}