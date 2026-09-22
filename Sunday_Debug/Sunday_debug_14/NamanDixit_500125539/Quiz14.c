#include <stdio.h>

int main() {

    int r, c;

    // Read rows and columns
    scanf("%d %d", &r, &c);

    // Read grid
    int grid[r][c];

    for (int i = 0; i < r; i++)
        for (int j = 0; j < c; j++)
            scanf("%d", &grid[i][j]);

    // Read number of portals
    int p;

    scanf("%d", &p);

    // Store portal information
    int portals[p][3];

    // BUG FIX 1:
    // i <= p was accessing portals[p], which is outside the array.
    // Correct condition is i < p.
    for (int i = 0; i < p; i++)
        scanf("%d %d %d",
              &portals[i][0],
              &portals[i][1],
              &portals[i][2]);

    int dp[r][c];

    // Starting cell
    dp[0][0] = grid[0][0];

    // BUG FIX 2:
    // We calculate DP and portal bonus together.
    // This ensures that once we reach a portal,
    // its bonus is included in the path value
    // before moving further.

    for (int i = 0; i < r; i++) {

        for (int j = 0; j < c; j++) {

            // Starting cell is already initialized
            if (i == 0 && j == 0)
                continue;

            // Find the best valid previous cell
            if (i == 0) {
                // Only left is possible
                dp[i][j] = dp[i][j - 1];

            } else if (j == 0) {
                // Only top is possible
                dp[i][j] = dp[i - 1][j];

            } else {
                // We can come from either top or left
                if (dp[i - 1][j] > dp[i][j - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i][j - 1];
            }

            // Collect energy of current cell
            dp[i][j] += grid[i][j];

            // Check whether current cell is a portal
            for (int k = 0; k < p; k++) {

                int pr = portals[k][0];
                int pc = portals[k][1];
                int bonus = portals[k][2];

                // If current cell is the portal
                if (i == pr && j == pc) {
                    // Add portal bonus AFTER collecting cell energy
                    dp[i][j] += bonus;
                }
            }
        }
    }

    // Print maximum energy
    printf("%d\n", dp[r - 1][c - 1]);

    return 0;
}
