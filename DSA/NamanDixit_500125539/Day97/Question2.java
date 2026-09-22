import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {

        // Create Scanner object
        // This is used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Take number of rows
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        // Take number of columns
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        // Create the grid
        int[][] grid = new int[rows][cols];

        // Take grid values from the user
        System.out.println("Enter grid values:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                // Read each value
                grid[i][j] = sc.nextInt();
            }
        }

        // Find the minimum path sum
        int answer = minPathSum(grid);

        // Print the answer
        System.out.println("Minimum Path Sum = " + answer);

        // Close Scanner
        sc.close();
    }


    // Function to find minimum path sum
    public static int minPathSum(int[][] grid) {

        // Find number of rows
        int rows = grid.length;

        // Find number of columns
        int cols = grid[0].length;


        // dp[i][j] means:
        // Minimum sum needed to reach
        // cell (i, j) from the top-left

        int[][] dp = new int[rows][cols];


        // Starting point
        //
        // We start at the top-left cell
        // so its minimum sum is simply itself
        dp[0][0] = grid[0][0];


        // Fill the first row
        //
        // We can only come from the LEFT
        for (int j = 1; j < cols; j++) {

            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }


        // Fill the first column
        //
        // We can only come from ABOVE
        for (int i = 1; i < rows; i++) {

            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }


        // Fill the remaining cells
        for (int i = 1; i < rows; i++) {

            for (int j = 1; j < cols; j++) {

                // We can reach the current cell
                // from two directions:
                //
                // 1. From ABOVE
                // 2. From LEFT
                //
                // We choose the smaller one.

                dp[i][j] = Math.min(
                    dp[i - 1][j],      // From above
                    dp[i][j - 1]       // From left
                ) + grid[i][j];

                // Add the value of the current cell
            }
        }


        // The bottom-right cell contains
        // the minimum path sum
        return dp[rows - 1][cols - 1];
    }
}