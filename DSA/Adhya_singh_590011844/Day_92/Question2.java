import java.util.*;

public class Main {

    static long rob(int[] nums) {
        long prev2 = 0;  
        long prev1 = 0;  

        for (int money : nums) {
            long current = Math.max(prev1, prev2 + money);

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(rob(nums));

        sc.close();
    }
}