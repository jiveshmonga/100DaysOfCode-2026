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

    for (int i = 0; i < r; i++) {
        for (int j = 0; j < c; j++) {
            if (i == 0 && j == 0) {
                dp[i][j] = grid[i][j];
            } else {
                int fromTop = (i > 0) ? dp[i - 1][j] : -1000000000;
                int fromLeft = (j > 0) ? dp[i][j - 1] : -1000000000;

                dp[i][j] = (fromTop > fromLeft ? fromTop : fromLeft) + grid[i][j];
            }

            for (int k = 0; k < p; k++) {
                if (portals[k][0] == i && portals[k][1] == j)
                    dp[i][j] += portals[k][2];
            }
        }
    }

    printf("%d\n", dp[r - 1][c - 1]);

    return 0;
}
