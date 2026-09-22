import java.util.*;
class Question2 {
    public static void main(String[] args) {
        int N = 6;
        int[] energy = {5, 10, 20, 15, 25, 30};
        int[] dp = new int[N];
        dp[0] = energy[0];
        dp[1] = Math.max(energy[0], energy[1]);
        for (int i = 2; i < N; i++) {
            dp[i] = energy[i] + Math.max(dp[i - 1], dp[i - 2]);
        }
        System.out.println(dp[N - 1]);
    }
}