import java.util.Scanner;
import java.util.Stack;

public class DaysUntil_a_Warmer_Temperature {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] temperatures = new int[n];
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            temperatures[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                   temperatures[i] > temperatures[stack.peek()]) {

                int prevIndex = stack.pop();

                answer[prevIndex] = i - prevIndex;
            }

            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }

        sc.close();
    }
}