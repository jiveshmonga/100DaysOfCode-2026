import java.util.*;
public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] grid = new char[r][c];
        for (int i = 0; i < r; i++)
            grid[i] = sc.next().toCharArray();
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    grid[i][j] = '0';
                    int[][] d = {{1,0},{-1,0},{0,1},{0,-1}};
                    while (!q.isEmpty()) {
                        int[] x = q.poll();
                        for (int[] dir : d) {
                            int ni = x[0] + dir[0];
                            int nj = x[1] + dir[1];
                            if (ni >= 0 && ni < r && nj >= 0 && nj < c && grid[ni][nj] == '1') {
                                grid[ni][nj] = '0';
                                q.add(new int[]{ni, nj});
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}