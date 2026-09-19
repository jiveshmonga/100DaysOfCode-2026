public class HouseRobber {

    public static long rob(int[] nums) {

        int n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        long prev2 = nums[0];
        long prev1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {

            long current = Math.max(
                prev1,
                nums[i] + prev2
            );

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {

        int[] nums = {2, 7, 9, 3, 1};

        System.out.println(rob(nums));
    }
}