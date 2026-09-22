import java.util.*;
public class Question1
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] ans=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            ans[i]=ans[i>>1]+(i&1);
        }
        System.out.println(Arrays.toString(ans));
    }
}