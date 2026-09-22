import java.util.*;
public class Question1
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] points=new int[n][2];
        for(int i=0;i<n;i++)
        {
            points[i][0]=sc.nextInt();
            points[i][1]=sc.nextInt();
        }
        Arrays.sort(points,(a,b)->Long.compare(a[1],b[1]));
        int arrows=1;
        long end=points[0][1];
        for(int i=1;i<n;i++)
        {
            if(points[i][0]>end)
            {
                arrows++;
                end=points[i][1];
            }
        }
        System.out.println(arrows);
    }
}