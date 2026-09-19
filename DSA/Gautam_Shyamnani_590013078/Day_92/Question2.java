import java.util.*;

public class Question2 {

    public static long rob(long[] nums) {
        long prev2 = 0;
        long prev1 = 0;

        for (long money : nums) {
            long take = money + prev2;

            long skip = prev1;

            long current = Math.max(take, skip);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] nums = new long[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }

        System.out.println(rob(nums));

        sc.close();
    }
}