import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] energy = new int[n];

        for (int i = 0; i < n; i++) {
            energy[i] = sc.nextInt();
        }

        int[] dp = new int[n];

        // Robot starts from floor 1
        dp[0] = energy[0];

        // To reach floor 2, robot must come from floor 1
        dp[1] = energy[0] + energy[1];

        for (int i = 2; i < n; i++) {
            dp[i] = energy[i] + Math.max(dp[i - 1], dp[i - 2]);
        }

        System.out.println(dp[n - 1]);

        sc.close();
    }
}
