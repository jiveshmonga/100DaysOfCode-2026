import java.util.*;
class Question2 {
    public static void main(String[] args) {
        int T=7;
        int[] duration={2,3,4,5};
        int[] happiness={4,5,7,8};
        int n=duration.length;
        int[][] dp=new int[n+1][T+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=T;j++){
                dp[i][j]=dp[i-1][j];

                if(duration[i-1]<=j){
                    dp[i][j]=Math.max(dp[i][j],
                        happiness[i-1]+dp[i-1][j-duration[i-1]]);
                }
            }
        }
        System.out.println(dp[n][T]);
    }
}