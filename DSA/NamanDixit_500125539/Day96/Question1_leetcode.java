
public class Question1_leetcode {
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
                        dp[i - 1][j], // From above
                        dp[i][j - 1] // From left
                ) + grid[i][j];

                // Add the value of the current cell
            }
        }

        // The bottom-right cell contains
        // the minimum path sum
        return dp[rows - 1][cols - 1];
    }

}
