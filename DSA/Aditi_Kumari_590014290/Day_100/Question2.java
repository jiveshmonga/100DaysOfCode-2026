package Day_100;

import java.util.Stack;

public class Question2 {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int previousDay = stack.pop();
                answer[previousDay] = i - previousDay;
            }

            stack.push(i);
        }

        return answer;
    }
}
