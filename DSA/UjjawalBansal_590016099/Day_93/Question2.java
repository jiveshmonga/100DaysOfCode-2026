import java.util.Scanner;

public class Question2 {
    
    public static int strangePrinter(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int n = s.length();
        int[][] dp = new int[n][n];
        
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; 
                
                if (len == 1) {
                    dp[i][j] = 1;
                } 
                else {
                    dp[i][j] = dp[i][j - 1] + 1;
                    
                    for (int k = i; k < j; k++) {
                        if (s.charAt(k) == s.charAt(j)) {
                            
                            int leftCost = dp[i][k];
                            int rightCost = (k + 1 <= j - 1) ? dp[k + 1][j - 1] : 0; 
                            
                            dp[i][j] = Math.min(dp[i][j], leftCost + rightCost);
                        }
                    }
                }
            }
        }
        
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the length of the string (n): ");
        if (!sc.hasNextInt()) {
            System.out.println("Invalid input.");
            return;
        }
        int n = sc.nextInt();
        
        System.out.print("Enter the string: ");
        String s = sc.next();
        
        int result = strangePrinter(s);
        System.out.println("Output (Minimum turns): " + result);
        
        sc.close();
    }
}