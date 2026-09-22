import java.util.*;

public class Main {

    static int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] ans = countBits(n);

        for (int i = 0; i <= n; i++) {
            System.out.print(ans[i]);

            if (i < n) {
                System.out.print(" ");
            }
        }

        sc.close();
    }
}