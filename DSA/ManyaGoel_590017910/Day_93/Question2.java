import java.util.Scanner;

public class Question2 {
    public static int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + 1;
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) == s.charAt(j)) {
                        int turns = dp[i][k];
                        if (k + 1 <= j - 1)
                            turns += dp[k + 1][j - 1];
                        dp[i][j] = Math.min(dp[i][j], turns);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = sc.nextInt();

        System.out.print("Enter the string s: ");
        String s = sc.next();

        System.out.println("Minimum number of turns required: " + strangePrinter(s));
        sc.close();
    }
}