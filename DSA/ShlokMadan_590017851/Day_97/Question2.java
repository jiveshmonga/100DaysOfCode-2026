import java.util.*;
public class Question2
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        long[] energy=new long[n];

        for(int i=0;i<n;i++)
        {
            energy[i]=sc.nextLong();
        }

        long prev2=energy[0];
        long prev1=energy[0]+energy[1];

        for(int i=2;i<n;i++)
        {
            long current=energy[i]+Math.max(prev1,prev2);
            prev2=prev1;
            prev1=current;
        }

        System.out.println(prev1);
    }
}