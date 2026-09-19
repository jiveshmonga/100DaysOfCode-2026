import java.util.*;

public class Question2 {
    static long happiness(int n, int T, int[] duration, int[] points) {
        long[] dp = new long[T + 1];

        for (int i = 0; i < n; i++) {
            int d = duration[i], p = points[i];
            if (d > T) continue;

            for (int t = T; t >= d; t--)
                dp[t] = Math.max(dp[t], dp[t - d] + p);
        }
        return dp[T];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of activities: ");
        int n = sc.nextInt();

        System.out.print("Enter the available time T: ");
        int T = sc.nextInt();

        int[] duration = new int[n];
        int[] points = new int[n];

        System.out.println("Enter the duration of each activity:");
        for (int i = 0; i < n; i++)
            duration[i] = sc.nextInt();

        System.out.println("Enter the happiness points of each activity:");
        for (int i = 0; i < n; i++)
            points[i] = sc.nextInt();

        System.out.println("Maximum happiness: " + happiness(n, T, duration, points));
        
        sc.close();
    }
}