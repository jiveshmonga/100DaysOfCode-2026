import java.util.*;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static void dfs(char[][] grid, int r, int c, int m, int n) {

        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        for (int k = 0; k < 4; k++) {
            dfs(grid, r + dr[k], c + dc[k], m, n);
        }
    }

    static int numIslands(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int islands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    islands++;
                    dfs(grid, i, j, m, n);
                }
            }
        }

        return islands;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            String row = sc.next();
            grid[i] = row.toCharArray();
        }

        System.out.println(numIslands(grid));

        sc.close();
    }
}