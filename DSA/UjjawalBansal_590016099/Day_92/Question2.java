import java.util.Scanner;

public class Question2 {
    public static int houseRobber(int[] nums) {
        if (nums.length == 1) return nums[0];
        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);

        int curr = 0;
        for (int i = 2; i < nums.length; i++) {
            curr = Math.max(nums[i] + a, b);
            a = b;
            b = curr;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number houses: ");
        int n = sc.nextInt();
        
        int[] money = new int[n];
        System.out.print("Enter the money in each house: ");
        for (int i = 0; i < n; i++) {
            money[i] = sc.nextInt();
        }

        int ans = houseRobber(money);
        System.out.println("Maximum amount of money that can be robbed without robbing any 2 adjacent houses: " + ans);
        sc.close();
    }
}
