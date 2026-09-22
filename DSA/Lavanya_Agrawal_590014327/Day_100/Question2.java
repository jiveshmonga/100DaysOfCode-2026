import java.util.*;

public class Question2 {

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty()
                    && temperatures[i] > temperatures[stack.peek()]) {

                int previousDay = stack.pop();
                answer[previousDay] = i - previousDay;
            }

            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] temperatures = new int[n];

        for (int i = 0; i < n; i++) {
            temperatures[i] = sc.nextInt();
        }

        int[] answer = dailyTemperatures(temperatures);

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i]);

            if (i < n - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        sc.close();
    }
}