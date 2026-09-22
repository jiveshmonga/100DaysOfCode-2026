import java.util.*;

public class Main {

    static int m, n;
    static char[][] grid;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void dfs(int r, int c) {

        if (r < 0 || r >= m || c < 0 || c >= n
                || grid[r][c] == '0') {
            return;
        }

        // Mark as visited
        grid[r][c] = '0';

        // Visit 4 directions
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            dfs(nr, nc);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        grid = new char[m][n];

        for (int i = 0; i < m; i++) {
            grid[i] = sc.next().toCharArray();
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(count);
    }
}
