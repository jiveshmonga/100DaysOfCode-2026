import java.util.Arrays;
import java.util.Scanner;

public class Question2 {
    
    public static long theSignalRelay(int n, int[] signal) {
        long[] dp = new long[n];
        
        Arrays.fill(dp, Long.MAX_VALUE);
        dp[0] = 0; 
        
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                long diff = signal[j] - signal[i];
                long jumpCost = diff * diff;
                
                if (dp[i] + jumpCost < dp[j]) {
                    dp[j] = dp[i] + jumpCost;
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of relay stations: ");
        int n = sc.nextInt();
        
        int[] signal = new int[n];
        System.out.print("Enter the " + n + " signal strengths: ");
        for (int i = 0; i < n; i++) {
            signal[i] = sc.nextInt();
        }
        
        long result = theSignalRelay(n, signal);
        System.out.println("Output (Minimum Cost): " + result);
        
        sc.close();
    }
}