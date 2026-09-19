import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {

        // Create Scanner object to take input from the user
        Scanner sc = new Scanner(System.in);

        // Take the maximum available time
        System.out.print("Enter total available time: ");
        int T = sc.nextInt();

        // Take the number of activities
        System.out.print("Enter number of activities: ");
        int n = sc.nextInt();

        // Create an array to store duration of each activity
        int[] duration = new int[n];

        // Create an array to store happiness of each activity
        int[] happiness = new int[n];

        // Take duration of all activities
        System.out.println("Enter duration of activities:");

        for (int i = 0; i < n; i++) {
            duration[i] = sc.nextInt();
        }

        // Take happiness of all activities
        System.out.println("Enter happiness of activities:");

        for (int i = 0; i < n; i++) {
            happiness[i] = sc.nextInt();
        }

        // Create DP array
        //
        // dp[t] = maximum happiness we can get
        //         when we have t amount of time
        int[] dp = new int[T + 1];

        // Go through every activity one by one
        for (int i = 0; i < n; i++) {

            // Start from T and move backwards
            //
            // We move backwards because each activity
            // can be selected only ONCE.
            for (int t = T; t >= duration[i]; t--) {

                // Option 1:
                // Do NOT take this activity
                //
                // dp[t] stays the same
                //
                // Option 2:
                // Take this activity
                //
                // dp[t - duration[i]] = happiness
                // we had before using this activity
                //
                // Then add happiness[i]
                //
                // Take the maximum of both options.

                dp[t] = Math.max(
                    dp[t],
                    dp[t - duration[i]] + happiness[i]
                );
            }
        }

        // dp[T] contains the maximum happiness
        // possible within the available time
        System.out.println("Maximum happiness = " + dp[T]);

        // Close Scanner
        sc.close();
    }
}