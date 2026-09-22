import java.util.*;

public class Main {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Put every number x at index x - 1
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n
                    && nums[nums[i] - 1] != nums[i]) {

                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Find the first index where the correct number is missing
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // If 1 to n are present, answer is n + 1
        return n + 1;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 0};
        System.out.println(firstMissingPositive(nums1)); // 3

        int[] nums2 = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums2)); // 2
    }
}