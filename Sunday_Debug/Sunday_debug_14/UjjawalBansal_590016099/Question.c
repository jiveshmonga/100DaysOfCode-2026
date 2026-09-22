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
    // FIX: Use at least size 1 because the constraints allow p = 0.
    int portals[p > 0 ? p : 1][3];

    // FIX: i <= p caused out-of-bounds access; last valid index is p - 1.
    for (int i = 0; i < p; i++)
        scanf("%d %d %d", &portals[i][0], &portals[i][1], &portals[i][2]);

    // FIX: portal bonuses must be included before DP so they affect the optimal path.
    for (int k = 0; k < p; k++) {

        int pr = portals[k][0];
        int pc = portals[k][1];
        int bonus = portals[k][2];

        // FIX: add portal bonus to the cell energy before calculating DP.
        grid[pr][pc] += bonus;
    }

    int dp[r][c];

    dp[0][0] = grid[0][0];

    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {

            if (i == 0 && j == 0)
                continue;

            int fromTop = (i > 0) ? dp[i-1][j] : 0;
            int fromLeft = (j > 0) ? dp[i][j-1] : 0;

            if (fromTop > fromLeft)
                dp[i][j] = fromTop;
            else
                dp[i][j]=fromLeft;

            dp[i][j] += grid[i][j];
        }
    }

    printf("%d\n", dp[r-1][c-1]);

    return 0;
}