//Count the number of separate groups of horizontally or vertically connected land cells (1) in a grid.
//Input:grid=["11000","11000","00100","00011"]. Output:3
#include <stdio.h>
#define MAX 100

void dfs(char grid[MAX][MAX], int rows, int cols, int r, int c) {
    if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != '1')
        return;
    grid[r][c] = '0';
    dfs(grid, rows, cols, r + 1, c);
    dfs(grid, rows, cols, r - 1, c);
    dfs(grid, rows, cols, r, c + 1);
    dfs(grid, rows, cols, r, c - 1);
}

int main() {
    int rows, cols;
    char grid[MAX][MAX];
    scanf("%d %d", &rows, &cols);
    for (int i = 0; i < rows; i++) {
        scanf("%s", grid[i]);
    }
    int count = 0;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (grid[i][j] == '1') {
                count++;
                dfs(grid, rows, cols, i, j);
            }
        }
    }
    printf("%d\n", count);
return 0;
}