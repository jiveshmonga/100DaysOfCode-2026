import java.util.*;

public class Main {

    static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        int INF = amount + 1;

        Arrays.fill(dp, INF);

        dp[0] = 0;

        for (int current = 1; current <= amount; current++) {

            for (int coin : coins) {

                if (coin <= current) {
                    dp[current] = Math.min(
                        dp[current],
                        dp[current - coin] + 1
                    );
                }
            }
        }

        return dp[amount] == INF ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int amount = sc.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.println(coinChange(coins, amount));

        sc.close();
    }
}