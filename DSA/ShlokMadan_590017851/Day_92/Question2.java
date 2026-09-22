import java.util.*;
public class Question2
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] nums=new long[n];
        for(int i=0;i<n;i++)
        {
            nums[i]=sc.nextLong();
        }
        long prev2=0;
        long prev1=0;
        for(int i=0;i<n;i++)
        {
            long current=Math.max(prev1,prev2+nums[i]);
            prev2=prev1;
            prev1=current;
        }
        System.out.println(prev1);
    }
}