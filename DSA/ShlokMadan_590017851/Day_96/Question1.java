import java.util.*;

public class Question1
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        int m=sc.nextInt();
        int n=sc.nextInt();

        int[][] grid=new int[m][n];

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                grid[i][j]=sc.nextInt();
            }
        }

        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0&&j==0)
                {
                    continue;
                }

                if(i==0)
                {
                    grid[i][j]+=grid[i][j-1];
                }
                else if(j==0)
                {
                    grid[i][j]+=grid[i-1][j];
                }
                else
                {
                    grid[i][j]+=Math.min(grid[i-1][j],grid[i][j-1]);
                }
            }
        }

        System.out.println(grid[m-1][n-1]);
    }
}