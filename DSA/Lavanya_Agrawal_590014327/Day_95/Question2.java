import java.util.*;

public class Question2 {

    public static int maxHappiness(int n, int T, int[] duration, int[] happiness) {
        int[] dp = new int[T + 1];

        for (int i = 0; i < n; i++) {
            for (int time = T; time >= duration[i]; time--) {
                dp[time] = Math.max(
                    dp[time],
                    dp[time - duration[i]] + happiness[i]
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

        System.out.println(maxHappiness(n, T, duration, happiness));

        sc.close();
    }
}