import java.util.*;

public class Question2 {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); 

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex; 
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] temperatures = new int[n];
        for (int i = 0; i < n; i++) {
            temperatures[i] = sc.nextInt();
        }
        int[] result = dailyTemperatures(temperatures);
        for (int r : result) {
            System.out.print(r + " ");
        }
        sc.close();
    }
}
