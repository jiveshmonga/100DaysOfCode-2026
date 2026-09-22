import java.util.*;

class Question2
{
    public static int[] dailyTemperatures(int[] temperatures)
    {
        int n=temperatures.length;
        int[] result=new int[n];
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<n;i++)
        {
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()])
            {
                int index=stack.pop();
                result[index]=i-index;
            }

            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args)
    {
        int[] temperatures={73,74,75,71,69,72,76,73};

        int[] result=dailyTemperatures(temperatures);

        for(int x:result)
        {
            System.out.print(x+" ");
        }
    }
}