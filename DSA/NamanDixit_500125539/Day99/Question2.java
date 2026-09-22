import java.util.Scanner;

public class Question2 {

    // Number of rows in the grid
    static int rows;

    // Number of columns in the grid
    static int cols;


    public static void main(String[] args) {

        // Create Scanner object
        // Used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Take number of rows
        System.out.print("Enter number of rows: ");
        rows = sc.nextInt();

        // Take number of columns
        System.out.print("Enter number of columns: ");
        cols = sc.nextInt();

        // Create the grid
        int[][] grid = new int[rows][cols];

        // Take grid input
        System.out.println("Enter grid:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                // Read each cell
                // 1 = land
                // 0 = water
                grid[i][j] = sc.nextInt();
            }
        }


        // Count the number of landmasses
        int answer = countLandmasses(grid);

        // Print the answer
        System.out.println("Number of landmasses = " + answer);

        // Close Scanner
        sc.close();
    }


    // Function to count landmasses
    public static int countLandmasses(int[][] grid) {

        // This variable stores the number
        // of separate landmasses
        int count = 0;


        // Visit every row
        for (int i = 0; i < rows; i++) {

            // Visit every column
            for (int j = 0; j < cols; j++) {

                // If we find land
                if (grid[i][j] == 1) {

                    // We found a NEW landmass
                    count++;

                    // Visit all connected land
                    // and turn it into water
                    dfs(grid, i, j);
                }
            }
        }


        // Return total number of landmasses
        return count;
    }


    // DFS function
    //
    // This function visits all land cells
    // connected to the current cell.
    public static void dfs(int[][] grid, int row, int col) {

        // Check if row is outside the grid
        if (row < 0 || row >= rows) {
            return;
        }

        // Check if column is outside the grid
        if (col < 0 || col >= cols) {
            return;
        }

        // If this cell is water,
        // there is nothing to visit
        if (grid[row][col] == 0) {
            return;
        }


        // Mark this land cell as visited
        //
        // We change 1 to 0
        // so that we don't count it again.
        grid[row][col] = 0;


        // Visit the cell ABOVE
        dfs(grid, row - 1, col);

        // Visit the cell BELOW
        dfs(grid, row + 1, col);

        // Visit the cell on the LEFT
        dfs(grid, row, col - 1);

        // Visit the cell on the RIGHT
        dfs(grid, row, col + 1);
    }
}