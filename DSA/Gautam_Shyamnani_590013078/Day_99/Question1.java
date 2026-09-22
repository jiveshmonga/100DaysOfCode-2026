import java.util.*;

public class Question1 {
    static int m, n;
    static char[][] grid;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        sc.nextLine(); 

        grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            String row = sc.nextLine();
            grid[i] = row.toCharArray();
        }

        visited = new boolean[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < m && ny >= 0 && ny < n &&
                grid[nx][ny] == '1' && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
