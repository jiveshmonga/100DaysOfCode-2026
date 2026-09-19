import java.util.Scanner;

public class Question2{

    // Function to find the maximum money we can rob
    static int rob(int[] nums) {

        // If there are no houses,
        // there is no money to rob
        if (nums.length == 0) {
            return 0;
        }

        // If there is only one house,
        // simply rob that house
        if (nums.length == 1) {
            return nums[0];
        }

        // dp[i] means:
        // Maximum money we can rob
        // from house 0 to house i
        int[] dp = new int[nums.length];

        // For the first house,
        // we can rob it
        dp[0] = nums[0];

        // For the second house,
        // choose the house with more money
        dp[1] = Math.max(nums[0], nums[1]);

        // Start from the third house
        for (int i = 2; i < nums.length; i++) {

            // We have two choices:
            //
            // Choice 1: Skip the current house
            //          → keep dp[i - 1]
            //
            // Choice 2: Rob the current house
            //          → we cannot rob the previous house
            //          → take dp[i - 2] + nums[i]
            //
            // Take whichever gives more money.
            dp[i] = Math.max(
                    dp[i - 1],
                    dp[i - 2] + nums[i]
            );
        }

        // The last dp value contains
        // the maximum money we can rob
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {

        // Scanner is used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Ask for the number of houses
        System.out.print("Enter number of houses: ");
        int n = sc.nextInt();

        // Create the array
        int[] nums = new int[n];

        // Take the money in each house
        System.out.println("Enter the money in each house:");

        for (int i = 0; i < n; i++) {

            // Store the money
            nums[i] = sc.nextInt();
        }

        // Find the maximum money
        int result = rob(nums);

        // Print the answer
        System.out.println("Maximum money = " + result);

        // Close Scanner
        sc.close();
    }
}