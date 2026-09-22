import java.util.*;

public class Question2 {
    public static int[] findWarmerDays(int[] temp) {
        int n = temp.length;
        int[] answer = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for (int day = 0; day < n; day++) {
            while (top >= 0 &&
                   temp[day] > temp[stack[top]]) {

                int prev = stack[top--];
                answer[prev] = day - prev;
            }
            stack[++top] = day;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        System.out.print("Enter the number of days: ");
        int n = sc.nextInt();

        int[] temperatures = new int[n];

        System.out.println("Enter the temperatures for each day:");
        for (int day = 0; day < n; day++) {
            temperatures[day] = sc.nextInt();
        }

        int[] answer = findWarmerDays(temperatures);
        System.out.println("Days to wait until a warmer temperature:");
        for (int day = 0; day < n; day++) {
            if (day > 0) {
                System.out.print(" ");
            }
            System.out.print(answer[day]);
        }
        System.out.println();
        sc.close();
    }
}