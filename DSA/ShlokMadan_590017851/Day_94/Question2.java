import java.util.*;

public class Question2
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();

        int[] cuts=new int[m+2];

        for(int i=1;i<=m;i++)
        {
            cuts[i]=sc.nextInt();
        }

        cuts[0]=0;
        cuts[m+1]=n;

        Arrays.sort(cuts);

        int[][] dp=new int[m+2][m+2];

        for(int len=2;len<m+2;len++)
        {
            for(int i=0;i+len<m+2;i++)
            {
                int j=i+len;
                dp[i][j]=Integer.MAX_VALUE;

                for(int k=i+1;k<j;k++)
                {
                    int cost=cuts[j]-cuts[i]+dp[i][k]+dp[k][j];
                    dp[i][j]=Math.min(dp[i][j],cost);
                }
            }
        }

        System.out.println(dp[0][m+1]);
    }
}