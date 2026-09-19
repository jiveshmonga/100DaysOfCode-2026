import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {

        // Create Scanner object
        // This is used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Take the maximum available time
        System.out.print("Enter total time: ");
        int T = sc.nextInt();

        // Take the number of activities
        System.out.print("Enter number of activities: ");
        int n = sc.nextInt();

        // Array to store duration of each activity
        int[] duration = new int[n];

        // Array to store happiness of each activity
        int[] happiness = new int[n];

        // Take duration values from user
        System.out.println("Enter durations:");

        for (int i = 0; i < n; i++) {
            duration[i] = sc.nextInt();
        }

        // Take happiness values from user
        System.out.println("Enter happiness values:");

        for (int i = 0; i < n; i++) {
            happiness[i] = sc.nextInt();
        }

        // dp[t] means:
        // Maximum happiness we can get
        // when we have t amount of time
        int[] dp = new int[T + 1];

        // Go through each activity
        for (int i = 0; i < n; i++) {

            // Start from T and move backwards
            //
            // We move backwards because
            // every activity can be used ONLY ONCE
            for (int t = T; t >= duration[i]; t--) {

                // OPTION 1:
                // Do not take the current activity
                // dp[t] remains as it is
                //
                // OPTION 2:
                // Take the current activity
                //
                // We have to spend duration[i] time
                // and we get happiness[i]
                //
                // So:
                // dp[t - duration[i]] + happiness[i]
                //
                // Take whichever gives more happiness

                dp[t] = Math.max(
                    dp[t],
                    dp[t - duration[i]] + happiness[i]
                );
            }
        }

        // dp[T] contains the maximum happiness
        // possible within T amount of time
        System.out.println("Maximum happiness = " + dp[T]);

        // Close Scanner
        sc.close();
    }
}