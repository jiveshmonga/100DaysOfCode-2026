import java.util.*;

public class Question2
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        String s=sc.next();

        int[][] dp=new int[n][n];

        for(int i=0;i<n;i++)
        {
            dp[i][i]=1;
        }

        for(int len=2;len<=n;len++)
        {
            for(int i=0;i+len-1<n;i++)
            {
                int j=i+len-1;

                dp[i][j]=dp[i+1][j]+1;

                for(int k=i+1;k<=j;k++)
                {
                    if(s.charAt(i)==s.charAt(k))
                    {
                        int left=k==i+1?0:dp[i+1][k-1];
                        int right=k==j?0:dp[k][j];

                        dp[i][j]=Math.min(dp[i][j],left+right);
                    }
                }
            }
        }

        System.out.println(dp[0][n-1]);
    }
}