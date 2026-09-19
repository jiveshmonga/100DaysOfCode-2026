package Day_94;
public class question2 {
    
import java.util.*;

public class MinCostCutStick {
    public static int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] arr = new int[m + 2];
        arr[0] = 0;
        arr[m + 1] = n;
        for (int i = 0; i < m; i++) arr[i + 1] = cuts[i];
        Arrays.sort(arr);

        int[][] dp = new int[m + 2][m + 2];

        for (int len = 2; len <= m + 1; len++) {
            for (int i = 0; i + len <= m + 1; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                        dp[i][k] + dp[k][j] + arr[j] - arr[i]);
                }
            }
        }
        return dp[0][m + 1];
    }

    public static void main(String[] args) {
        int n = 7;
        int[] cuts = {1, 3, 4, 5};
        System.out.println(minCost(n, cuts)); 
    }
}}
