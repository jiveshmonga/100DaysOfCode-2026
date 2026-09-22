#include <stdio.h>

void dfs(char grid[][100], int rows, int cols, int r, int c) {
    // Out of bounds or water
    if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != '1')
        return;

    // Mark as visited
    grid[r][c] = '0';

    // Up
    dfs(grid, rows, cols, r - 1, c);

    // Down
    dfs(grid, rows, cols, r + 1, c);

    // Left
    dfs(grid, rows, cols, r, c - 1);

    // Right
    dfs(grid, rows, cols, r, c + 1);
}

int main() {
    int rows, cols;
    scanf("%d %d", &rows, &cols);

    char grid[100][100];

    for (int i = 0; i < rows; i++) {
        scanf("%s", grid[i]);
    }

    int count = 0;

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {

            if (grid[i][j] == '1') {
                count++;

                // Visit the complete landmass
                dfs(grid, rows, cols, i, j);
            }
        }
    }

    printf("%d", count);

    return 0;
}
