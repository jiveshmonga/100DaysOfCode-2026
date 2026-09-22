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

    // BUG 1: Changed i <= p to i < p to prevent out-of-bounds access
    for (int i = 0; i < p; i++)
        scanf("%d %d %d", &portals[i][0], &portals[i][1], &portals[i][2]);

    // BUG 2: Moved portal logic BEFORE DP execution, and applied to 'grid' 
    // so the bonus energy propagates down the path.
    for (int k = 0; k < p; k++) {
        int pr = portals[k][0];
        int pc = portals[k][1];
        int bonus = portals[k][2];
        grid[pr][pc] += bonus;
    }

    int dp[r][c];
    dp[0][0] = grid[0][0];

    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            if (i == 0 && j == 0)
                continue;

            // BUG 3: Fallback boundary condition changed from 0 to -1
            int fromTop = (i > 0) ? dp[i-1][j] : -1;
            int fromLeft = (j > 0) ? dp[i][j-1] : -1;

            if (fromTop > fromLeft)
                dp[i][j] = fromTop;
            else
                dp[i][j] = fromLeft;

            dp[i][j] += grid[i][j];
        }
    }

    printf("%d\n", dp[r-1][c-1]);

    return 0;
}