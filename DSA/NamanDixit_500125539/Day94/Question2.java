import java.util.*;

public class Question2 {

    public static void main(String[] args) {

        // Scanner is used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Take the length of the stick
        System.out.print("Enter length of stick: ");
        int n = sc.nextInt();

        // Take the number of cuts
        System.out.print("Enter number of cuts: ");
        int m = sc.nextInt();

        // Create an array for the cuts
        int[] cuts = new int[m];

        // Take all cut positions from the user
        System.out.println("Enter cut positions:");

        for (int i = 0; i < m; i++) {
            cuts[i] = sc.nextInt();
        }

        // Call our function to find minimum cost
        int answer = minCost(n, cuts);

        // Print the answer
        System.out.println("Minimum cost = " + answer);

        // Close Scanner
        sc.close();
    }


    // Function to find minimum cost
    public static int minCost(int n, int[] cuts) {

        // Number of cuts
        int m = cuts.length;

        // Create a new array.
        //
        // We need to add:
        // 0 = beginning of stick
        // n = end of stick
        //
        // Example:
        // cuts = [1,3,4,5]
        //
        // new array:
        // [0,1,3,4,5,7]

        int[] arr = new int[m + 2];

        // Put 0 at the beginning
        arr[0] = 0;

        // Copy all cuts into the new array
        for (int i = 0; i < m; i++) {
            arr[i + 1] = cuts[i];
        }

        // Put n at the end
        arr[m + 1] = n;


        // Sort the cut positions
        //
        // This is very important because
        // we want the cuts in increasing order.
        Arrays.sort(arr);


        // dp[i][j] means:
        //
        // Minimum cost to make all cuts
        // between arr[i] and arr[j]
        //
        // Example:
        //
        // arr = [0,1,3,4,5,7]
        //
        // dp[0][5] means:
        // minimum cost to make all cuts
        // between 0 and 7

        int[][] dp = new int[m + 2][m + 2];


        // We calculate smaller sections first
        // and then use them to calculate
        // bigger sections.
        //
        // gap tells us the distance between
        // i and j.
        for (int gap = 2; gap < m + 2; gap++) {

            // i is the starting position
            for (int i = 0; i + gap < m + 2; i++) {

                // j is the ending position
                int j = i + gap;


                // Start with a very large value
                // because we want the minimum.
                dp[i][j] = Integer.MAX_VALUE;


                // Try every possible cut between i and j
                //
                // k represents the cut we choose
                // to perform FIRST.
                for (int k = i + 1; k < j; k++) {

                    // Cost of making this cut
                    //
                    // Current stick length:
                    // arr[j] - arr[i]
                    //
                    // Then we also need:
                    // left section cost
                    // + right section cost

                    int cost = (arr[j] - arr[i])
                             + dp[i][k]
                             + dp[k][j];


                    // Keep the smaller cost
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                    }
                }
            }
        }


        // dp[0][m + 1] represents
        // the minimum cost to make ALL cuts
        // from 0 to n.
        return dp[0][m + 1];
    }
}