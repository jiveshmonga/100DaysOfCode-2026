import java.util.*;

class Solution {
    public static int maxEnergy(int[] energy) {

        int n = energy.length;

        // dp[i] = maximum energy collected up to floor i
        int[] dp = new int[n];

        // Starting from floor 1
        dp[0] = energy[0];

        // Floor 2
        dp[1] = energy[1] + dp[0];

        // Calculate for remaining floors
        for (int i = 2; i < n; i++) {
            dp[i] = energy[i] + Math.max(dp[i - 1], dp[i - 2]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

        int[] energy = {5, 10, 20, 15, 25, 30};

        System.out.println(maxEnergy(energy));
    }
}