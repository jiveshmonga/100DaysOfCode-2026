import java.util.Scanner;

public class Question2 {
    public static long maxHappiness(int n, int T, int[] duration, long[] happiness) {
        long[] dp = new long[T + 1];
        
        for (int i = 0; i < n; i++) {
            for (int j = T; j >= duration[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - duration[i]] + happiness[i]);
            }
        }
        return dp[T];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of available activites: ");
        int n = sc.nextInt();

        System.out.print("Enter the total time available: ");
        int T = sc.nextInt();
        
        System.out.print("Enter the durations of activities: ");
        int[] duration = new int[n];
        for (int i = 0; i < n; i++) {
            duration[i] = sc.nextInt();
        }
        
        System.out.print("Enter the happiness of activities: ");
        long[] happiness = new long[n];
        for (int i = 0; i < n; i++) {
            happiness[i] = sc.nextLong(); 
        }
        
        long result = maxHappiness(n, T, duration, happiness);
        System.out.println("Maximum possible happiness: " + result);
        
        sc.close();
    }
}