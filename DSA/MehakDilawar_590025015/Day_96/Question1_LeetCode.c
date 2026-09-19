int minPathSum(int** grid, int gridSize, int* gridColSize) {
    int rows = gridSize;
    int cols = gridColSize[0];
    for (int j = 1; j < cols; j++) {
        grid[0][j] += grid[0][j - 1];
    }
    for (int i = 1; i < rows; i++) {
        grid[i][0] += grid[i - 1][0];
    }
    for (int i = 1; i < rows; i++) {
        for (int j = 1; j < cols; j++) {
            int min = (grid[i - 1][j] < grid[i][j - 1])
                      ? grid[i - 1][j]
                      : grid[i][j - 1];
            grid[i][j] += min;
        }
    }
    return grid[rows - 1][cols - 1];
}