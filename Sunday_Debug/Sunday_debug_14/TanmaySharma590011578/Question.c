
#include <stdio.h>

int main() {

    int r, c;

    scanf("%d %d", &r, &c);

    int grid[r][c];

    for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
            scanf("%d", &grid[i][j]);

    int p;

    scanf("%d", &p);

    int portals[p][3];

    for (int i = 0; i < p; i++)
        scanf("%d %d %d", &portals[i][0], &portals[i][1], &portals[i][2]);

    int dp[r][c];

    dp[0][0] = grid[0][0];

    /* Add portal bonus if the starting cell is a portal */
    for (int k = 0; k < p; k++) {
        if (portals[k][0] == 0 && portals[k][1] == 0)
            dp[0][0] += portals[k][2];
    }

    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {

            if (i == 0 && j == 0)
                continue;

            if (i == 0)
                dp[i][j] = dp[i][j - 1] + grid[i][j];
            else if (j == 0)
                dp[i][j] = dp[i - 1][j] + grid[i][j];
            else
                dp[i][j] = (dp[i - 1][j] > dp[i][j - 1])
                         ? dp[i - 1][j] + grid[i][j]
                         : dp[i][j - 1] + grid[i][j];

            /* Collect portal bonus after collecting cell energy */
            for (int k = 0; k < p; k++) {
                if (portals[k][0] == i && portals[k][1] == j)
                    dp[i][j] += portals[k][2];
            }
        }
    }

    printf("%d\n", dp[r - 1][c - 1]);

    return 0;
}
