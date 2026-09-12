import java.util.*;
public class Question2
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        int[][] clips=new int[n][2];
        for(int i=0;i<n;i++)
        {
            clips[i][0]=sc.nextInt();
            clips[i][1]=sc.nextInt();
        }
        int time=sc.nextInt();
        Arrays.sort(clips,(a,b)->Integer.compare(a[0],b[0]));
        int count=0;
        int current=0;
        int farthest=0;
        int i=0;
        while(current<time)
        {
            while(i<n&&clips[i][0]<=current)
            {
                farthest=Math.max(farthest,clips[i][1]);
                i++;
            }
            if(farthest==current)
            {
                System.out.println(-1);
                return;
            }
            count++;
            current=farthest;
        }
        System.out.println(count);
    }
}