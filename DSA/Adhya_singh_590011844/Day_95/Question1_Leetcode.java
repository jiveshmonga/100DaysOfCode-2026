import java.util.*;

public class Main {

    static int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int t0 = 0;
        int t1 = 1;
        int t2 = 1;

        for (int i = 3; i <= n; i++) {
            int current = t0 + t1 + t2;

            t0 = t1;
            t1 = t2;
            t2 = current;
        }

        return t2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(tribonacci(n));

        sc.close();
    }
}