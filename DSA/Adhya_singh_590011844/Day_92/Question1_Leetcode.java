import java.util.*;

public class Main {

    static int climbStairs(int n) {
        int a = 1;
        int b = 1;

        for (int i = 1; i < n; i++) {
            int next = a + b;
            a = b;
            b = next;
        }

        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(climbStairs(n));

        sc.close();
    }
}