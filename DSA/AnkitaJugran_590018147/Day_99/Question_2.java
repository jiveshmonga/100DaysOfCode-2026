import java.util.Scanner;

public class CountingLandMasses {

    static int m, n;
    static char[][] grid;

    // Four directions: up, down, left, right
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void dfs(int row, int col) {

        // Stack to store grid cell positions
        int[] stack = new int[m * n];
        int top = 0;

        // Mark as visited and push
        grid[row][col] = '0';
        stack[top++] = row * n + col;

        while (top > 0) {

            int cell = stack[--top];

            int r = cell / n;
            int c = cell % n;

            // Explore all 4 adjacent directions
            for (int d = 0; d < 4; d++) {

                int nr = r + dr[d];
                int nc = c + dc[d];

                // Check boundaries and whether it's land
                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == '1') {

                    // Mark visited before pushing
                    grid[nr][nc] = '0';

                    stack[top++] = nr * n + nc;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        grid = new char[m][n];

        // Read the grid
        for (int i = 0; i < m; i++) {
            grid[i] = sc.next().toCharArray();
        }

        int count = 0;

        // Traverse the entire grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Found a new landmass
                if (grid[i][j] == '1') {
                    count++;

                    // Visit all connected land cells
                    dfs(i, j);
                }
            }
        }

        System.out.println(count);

        sc.close();
    }
}