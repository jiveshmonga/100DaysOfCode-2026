import java.util.*;

public class Question1_Leetcode {

    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int prev = 1;
        int curr = 2;

        for (int i = 3; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }

        return curr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(climbStairs(n));

        sc.close();
    }
}