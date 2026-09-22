import java.util.*;

public class Main {

    static int m, n;
    static char[][] grid;

    // Four possible directions: up, down, left, right
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void dfs(int r, int c) {

        // Boundary check
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return;
        }

        // Stop if this cell is water
        if (grid[r][c] != '1') {
            return;
        }

        // Mark land as visited
        grid[r][c] = '0';

        // Visit all 4 adjacent cells
        for (int i = 0; i < 4; i++) {
            dfs(r + dr[i], c + dc[i]);
        }
    }

    public static int countLandmasses() {

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Found a new landmass
                if (grid[i][j] == '1') {

                    count++;

                    // Mark the complete landmass as visited
                    dfs(i, j);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            grid[i] = sc.next().toCharArray();
        }

        System.out.println(countLandmasses());

        sc.close();
    }
}