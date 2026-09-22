import java.util.Scanner;

public class Question2 {

    // Function to find the minimum number of clips
    // needed to cover [0, time]
    static int videoStitching(int[][] clips, int time) {

        // This tells us how far we can currently cover
        int currentEnd = 0;

        // This tells us the farthest point we can reach
        // using the clips we have looked at
        int farthest = 0;

        // This counts how many clips we have used
        int count = 0;

        // Keep going until we cover the required time
        while (currentEnd < time) {

            // Check every clip
            for (int i = 0; i < clips.length; i++) {

                // Get the start time of the clip
                int start = clips[i][0];

                // Get the end time of the clip
                int end = clips[i][1];

                // We can use this clip if its start time
                // is at or before our current coverage
                if (start <= currentEnd) {

                    // Choose the clip that reaches the farthest
                    if (end > farthest) {
                        farthest = end;
                    }
                }
            }

            // If we cannot extend our coverage,
            // it is impossible to cover the whole video
            if (farthest == currentEnd) {
                return -1;
            }

            // Move our current coverage to the farthest point
            currentEnd = farthest;

            // We used one more clip
            count++;
        }

        // Return the minimum number of clips
        return count;
    }

    public static void main(String[] args) {

        // Scanner is used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Take the number of clips
        System.out.print("Enter number of clips: ");
        int n = sc.nextInt();

        // Create a 2D array
        // Each clip has [start, end]
        int[][] clips = new int[n][2];

        // Take the clips from the user
        System.out.println("Enter start and end time for each clip:");

        for (int i = 0; i < n; i++) {

            // Take start time
            clips[i][0] = sc.nextInt();

            // Take end time
            clips[i][1] = sc.nextInt();
        }

        // Take the required video time
        System.out.print("Enter video time: ");
        int time = sc.nextInt();

        // Find the minimum number of clips
        int result = videoStitching(clips, time);

        // Print the answer
        if (result == -1) {
            System.out.println("It is impossible to cover the entire video.");
        } else {
            System.out.println("Minimum number of clips = " + result);
        }

        // Close Scanner
        sc.close();
    }
}