import java.util.*;

public class Main {

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

                int previousDay = stack.pop();
                answer[previousDay] = i - previousDay;
            }

            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}
