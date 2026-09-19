int minPathSum(int** grid, int gridSize, int* gridColSize) {
    int m = gridSize;
    int n = gridColSize[0];

    // First row
    for (int j = 1; j < n; j++) {
        grid[0][j] += grid[0][j - 1];
    }

    // First column
    for (int i = 1; i < m; i++) {
        grid[i][0] += grid[i - 1][0];
    }

    // Rest of the grid
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            int min = grid[i - 1][j];

            if (grid[i][j - 1] < min) {
                min = grid[i][j - 1];
            }

            grid[i][j] += min;
        }
    }

    return grid[m - 1][n - 1];
}
