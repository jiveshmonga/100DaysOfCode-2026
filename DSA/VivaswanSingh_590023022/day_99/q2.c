#include <stdio.h>

void dfs(char grid[][5], int rows, int cols, int r, int c)
{
    if (r < 0 || r >= rows || c < 0 || c >= cols)
        return;

    if (grid[r][c] != '1')
        return;

    // Mark land as visited
    grid[r][c] = '0';

    // Down
    dfs(grid, rows, cols, r + 1, c);

    // Up
    dfs(grid, rows, cols, r - 1, c);

    // Right
    dfs(grid, rows, cols, r, c + 1);

    // Left
    dfs(grid, rows, cols, r, c - 1);
}

int countLandmasses(char grid[][5], int rows, int cols)
{
    int count = 0;

    for (int i = 0; i < rows; i++)
    {
        for (int j = 0; j < cols; j++)
        {
            if (grid[i][j] == '1')
            {
                count++;

                dfs(grid, rows, cols, i, j);
            }
        }
    }

    return count;
}

int main()
{
    char grid[4][5] = {
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}
    };

    int rows = 4;
    int cols = 5;

    int result = countLandmasses(grid, rows, cols);

    printf("Number of landmasses: %d\n", result);

    return 0;
}