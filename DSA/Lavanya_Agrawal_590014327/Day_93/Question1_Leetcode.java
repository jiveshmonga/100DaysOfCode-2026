import java.util.*;

public class Question1_Leetcode {

    public static int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] result = countBits(n);

        System.out.println(Arrays.toString(result));

        sc.close();
    }
}