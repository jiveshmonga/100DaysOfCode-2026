class Solution {
    public int maxEnergy(int n, int[] energy) {
        // dp[i] = max energy collected when standing on floor i (0-indexed)
        int[] dp = new int[n];

        // Base case: the robot starts on floor 1 and collects its energy
        dp[0] = energy[0];

        // Floor 2 can only be reached from floor 1 (a 2-step would need floor 0)
        if (n > 1) {
            dp[1] = energy[0] + energy[1];
        }

        // For every later floor, arrive from the better of the two previous floors
        for (int i = 2; i < n; i++) {
            dp[i] = energy[i] + Math.max(dp[i - 1], dp[i - 2]);
        }

        // The robot must end on the top floor
        return dp[n - 1];
    }
}
