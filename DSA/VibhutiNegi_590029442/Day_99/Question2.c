#include <stdio.h>
void dfs(char grid[][301], int m, int n, int r, int c) {
    if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != '1')
        return;
    grid[r][c] = '0';
    dfs(grid, m, n, r + 1, c);
    dfs(grid, m, n, r - 1, c);
    dfs(grid, m, n, r, c + 1);
    dfs(grid, m, n, r, c - 1);
}
int main() {
    int m, n;
    scanf("%d %d", &m, &n);
    char grid[301][301];
    for (int i = 0; i < m; i++) {
        scanf("%s", grid[i]);
    }
    int islands = 0;
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == '1') {
                islands++;
                dfs(grid, m, n, i, j);
            }
        }
    }
    printf("%d\n", islands);
    return 0;
}