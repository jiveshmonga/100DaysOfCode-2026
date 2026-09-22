import java.util.*;

public class Question2 {
    public static int[] findWarmerDays(int[] temp) {
        int n = temp.length;
        int[] ans = new int[n];
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            while (top >= 0 && temp[i] > temp[stack[top]]) {
                int idx = stack[top--];
                ans[idx] = i - idx;
            }
            stack[++top] = i;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of days: ");
        int n = sc.nextInt();

        int[] temp = new int[n];

        System.out.println("Enter the temperatures for " + n + " days:");
        for (int i = 0; i < n; i++) {
            temp[i] = sc.nextInt();
        }
        int[] ans = findWarmerDays(temp);
        System.out.println("Days to wait for a warmer temperature:");
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(ans[i]);
        }
        System.out.println();
        sc.close();
    }
}