import java.util.*;

class Main {
    static int m, n;
    static char[][] grid;

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

    static void dfs(int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }
        if (grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        dfs(row - 1, col);
        dfs(row + 1, col);
        dfs(row, col - 1);
        dfs(row, col + 1);
    }
}