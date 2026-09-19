int minPathSum(int** grid, int gridSize, int* gridColSize)
{
    int m = gridSize;
    int n = gridColSize[0];

    for (int j = 1; j < n; j++)
        grid[0][j] += grid[0][j - 1];

    for (int i = 1; i < m; i++)
        grid[i][0] += grid[i - 1][0];

    for (int i = 1; i < m; i++)
    {
        for (int j = 1; j < n; j++)
        {
            int minPrevious;

            if (grid[i - 1][j] < grid[i][j - 1])
                minPrevious = grid[i - 1][j];
            else
                minPrevious = grid[i][j - 1];

            grid[i][j] += minPrevious;
        }
    }

    return grid[m - 1][n - 1];
}