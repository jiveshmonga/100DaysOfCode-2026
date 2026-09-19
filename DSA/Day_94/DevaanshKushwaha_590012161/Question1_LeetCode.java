class Solution {
    public boolean divisorGame(int n) {
        // dp[i] = true if the player to move WINS when board shows i
        boolean[] dp = new boolean[n + 1];
        dp[0] = false; // no moves possible, player to move loses
        if (n >= 1) dp[1] = false; // no valid x (0 < x < 1), player loses

        for (int i = 2; i <= n; i++) {
            for (int x = 1; x < i; x++) {
                if (i % x == 0 && !dp[i - x]) {
                    dp[i] = true; // found a move that puts opponent in a losing state
                    break;
                }
            }
            // if no such x found, dp[i] stays false (default)
        }

        return dp[n];
    }
}
