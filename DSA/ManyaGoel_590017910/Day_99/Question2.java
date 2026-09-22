import java.util.Scanner;

public class Question2 {
    public static int countLandmasses(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs_search(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private static void dfs_search(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        
        dfs_search(grid, i + 1, j); 
        dfs_search(grid, i - 1, j); 
        dfs_search(grid, i, j + 1);
        dfs_search(grid, i, j - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of rows: ");
        int m = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int n = sc.nextInt();
        sc.nextLine(); 
        
        char[][] grid = new char[m][n];
        System.out.println("Enter the " + m + " rows of strings ('1' for land, '0' for water):");
        for (int i = 0; i < m; i++) {
            String row = sc.nextLine();
            grid[i] = row.toCharArray();
        }
        
        int result = countLandmasses(grid);
        System.out.println("Total Landmasses: " + result);
        sc.close();
    }
}