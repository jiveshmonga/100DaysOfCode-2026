import java.util.Scanner;

public class Question2 {

    // Function to find the minimum number of turns
    static int strangePrinter(String s) {

        // If the string is empty,
        // we need 0 turns
        if (s.length() == 0) {
            return 0;
        }

        // ------------------------------------------------
        // STEP 1: Remove consecutive duplicate characters
        // ------------------------------------------------

        String newString = "";

        // Go through every character
        for (int i = 0; i < s.length(); i++) {

            // Add the character only if:
            // 1. It is the first character, OR
            // 2. It is different from the previous character
            if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {

                newString = newString + s.charAt(i);
            }
        }

        // Replace the original string
        s = newString;

        // Get the new length
        int n = s.length();

        // ------------------------------------------------
        // STEP 2: Create the DP table
        // ------------------------------------------------

        // dp[i][j] means:
        // minimum turns needed to print
        // characters from index i to index j
        int[][] dp = new int[n][n];

        // ------------------------------------------------
        // STEP 3: One character needs only 1 turn
        // ------------------------------------------------

        for (int i = 0; i < n; i++) {

            dp[i][i] = 1;
        }

        // ------------------------------------------------
        // STEP 4: Solve bigger substrings
        // ------------------------------------------------

        // len = length of the substring
        for (int len = 2; len <= n; len++) {

            // Start index
            for (int i = 0; i <= n - len; i++) {

                // End index
                int j = i + len - 1;

                // First assume that we print
                // s[j] separately.
                //
                // So:
                // dp[i][j] = dp[i][j-1] + 1
                dp[i][j] = dp[i][j - 1] + 1;

                // Now check if s[j] is the same
                // as any previous character
                for (int k = i; k < j; k++) {

                    // If the characters are the same
                    if (s.charAt(k) == s.charAt(j)) {

                        // We can print these two characters
                        // in the SAME turn.
                        //
                        // Split the problem into two parts:
                        //
                        // Left part:
                        // dp[i][k]
                        //
                        // Middle/right part:
                        // dp[k + 1][j - 1]
                        //
                        // If k + 1 > j - 1,
                        // there is no middle part.
                        int middle = 0;

                        if (k + 1 <= j - 1) {
                            middle = dp[k + 1][j - 1];
                        }

                        // Calculate the number of turns
                        int turns = dp[i][k] + middle;

                        // Keep the smaller answer
                        dp[i][j] = Math.min(dp[i][j], turns);
                    }
                }
            }
        }

        // The answer for the whole string
        // is stored at dp[0][n-1]
        return dp[0][n - 1];
    }

    public static void main(String[] args) {

        // Scanner is used to take input
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter the string
        System.out.print("Enter the string: ");

        // Take the string from the user
        String s = sc.nextLine();

        // Find the minimum number of turns
        int result = strangePrinter(s);

        // Print the answer
        System.out.println("Minimum number of turns = " + result);

        // Close Scanner
        sc.close();
    }
}