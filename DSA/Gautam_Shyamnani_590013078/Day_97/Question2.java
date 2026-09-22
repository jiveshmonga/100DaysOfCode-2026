import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] energy = new int[N];

        for (int i = 0; i < N; i++) {
            energy[i] = sc.nextInt();
        }

        int prev2 = energy[0]; // dp[1]
        int prev1 = energy[0] + energy[1]; // dp[2]

        if (N == 2) {
            System.out.println(prev1);
            return;
        }

        int curr = 0;
        for (int i = 2; i < N; i++) {
            curr = Math.max(prev1, prev2) + energy[i];
            prev2 = prev1;
            prev1 = curr;
        }

        System.out.println(curr);
    }
}

