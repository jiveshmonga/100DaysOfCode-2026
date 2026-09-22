import java.util.*;

public class Question2
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        long[] signal=new long[n];

        for(int i=0;i<n;i++)
        {
            signal[i]=sc.nextLong();
        }

        long[] dp=new long[n];
        Arrays.fill(dp,Long.MAX_VALUE);

        dp[0]=0;

        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                long diff=signal[i]-signal[j];
                long cost=diff*diff;

                dp[i]=Math.min(dp[i],dp[j]+cost);
            }
        }

        System.out.println(dp[n-1]);
    }
}