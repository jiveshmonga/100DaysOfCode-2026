import java.util.Arrays;
import java.util.Scanner;

public class Question2 {
    
    public static int minCost(int n, int[] cuts) {
        int m = cuts.length;
        
        int[] c = new int[m + 2];
        for (int i = 0; i < m; i++) {
            c[i + 1] = cuts[i];
        }
        c[0] = 0;
        c[m + 1] = n;
        
        Arrays.sort(c);
        
        int[][] dp = new int[m + 2][m + 2];

        for (int len = 2; len <= m + 1; len++) {
            for (int i = 0; i <= m + 1 - len; i++) {
                int j = i + len; // Ending boundary
                
                dp[i][j] = Integer.MAX_VALUE;
                
                for (int k = i + 1; k < j; k++) {
                    int currentCost = dp[i][k] + dp[k][j] + (c[j] - c[i]);
                    
                    dp[i][j] = Math.min(dp[i][j], currentCost);
                }
            }
        }
        
        return dp[0][m + 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the length of the stick (n): ");
        int n = sc.nextInt();
        
        System.out.print("Enter the number of cuts (m): ");
        int m = sc.nextInt();
        
        int[] cuts = new int[m];
        System.out.print("Enter the " + m + " space-separated cut positions: ");
        for (int i = 0; i < m; i++) {
            cuts[i] = sc.nextInt();
        }
        
        int result = minCost(n, cuts);
        System.out.println("Output (Minimum Cost): " + result);
        
        sc.close();
    }
}