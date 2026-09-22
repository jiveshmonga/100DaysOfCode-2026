import java.util.*; 
 
public class Question2 { 
    public static long rob(int[] nums) { 
        long prev1 = 0;
        long prev2 = 0;
 
        for (int money : nums) { 
            long current = Math.max(prev1, prev2 + money); 
            prev2 = prev1; 
            prev1 = current; 
        } 
        return prev1; 
    } 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
 
        System.out.print("Enter the number of houses: "); 
        int n = sc.nextInt(); 

        int[] nums = new int[n]; 
 
        System.out.println("Enter the amount of money in each house:"); 
        for (int i = 0; i < n; i++) { 
            System.out.print("Enter money for house " + (i + 1) + ": "); 
            int value = sc.nextInt(); 
            nums[i] = value;
        }
        System.out.println("The amount of money in each house is: "+ Arrays.toString(nums));
        System.out.println("Maximum amount that can be robbed is: " + rob(nums)); 
        sc.close(); 
    } 
}