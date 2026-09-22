import java.util.Scanner;

public class EnergyTower {

    public static int maxEnergy(int[] energy, int n) {
        int[] dp = new int[n];

        dp[0] = energy[0];

        if (n > 1) {
            dp[1] = energy[0] + energy[1];
        }

        for (int i = 2; i < n; i++) {
            dp[i] = energy[i] + Math.max(dp[i - 1], dp[i - 2]);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] energy = new int[n];

        for (int i = 0; i < n; i++) {
            energy[i] = sc.nextInt();
        }

        System.out.println(maxEnergy(energy, n));

        sc.close();
    }
}