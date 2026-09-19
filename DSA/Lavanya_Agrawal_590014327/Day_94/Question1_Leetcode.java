import java.util.*;

public class Question1_Leetcode {

    public static boolean divisorGame(int n) {
        boolean[] dp = new boolean[n + 1];

        dp[1] = false;

        for (int i = 2; i <= n; i++) {
            for (int x = 1; x < i; x++) {
                if (i % x == 0 && !dp[i - x]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(divisorGame(n));

        sc.close();
    }
}