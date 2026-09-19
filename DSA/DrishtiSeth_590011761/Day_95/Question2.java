class Solution {
    public int maxHappiness(int n, int T, int[] duration, int[] happiness) {

        int[] dp = new int[T + 1];

        for (int i = 0; i < n; i++) {

            // Traverse backwards because each activity
            // can be selected only once
            for (int time = T; time >= duration[i]; time--) {

                dp[time] = Math.max(
                    dp[time],
                    happiness[i] + dp[time - duration[i]]
                );
            }
        }

        return dp[T];
    }
}
